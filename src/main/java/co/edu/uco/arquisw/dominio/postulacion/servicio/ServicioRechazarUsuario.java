package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.MotivoRechazoPostulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioRechazarUsuario {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;

    public ServicioRechazarUsuario(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.postulacionRepositorioComando = postulacionRepositorioComando;
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(MotivoRechazoPostulacion motivoRechazoPostulacion, Long id) throws MessagingException {
        validarSiExistePostulacionConId(id);

        var postulacionDTO = postulacionRepositorioConsulta.consultarPostulacionPorId(id);
        var postulacion = Postulacion.crear(postulacionDTO.getRoles(), false, true);
        var proyecto = this.necesidadRepositorioConsulta.consultarProyectoPorId(postulacionDTO.getProyectoID());
        var correo = this.personaRepositorioConsulta.consultarPorId(postulacionDTO.getUsuarioID()).getCorreo();
        var asunto = Mensajes.HAS_SIDO_RECHAZADO_AL_PROYECTO;
        var cuerpo = Mensajes.EL_ADMINISTRADOR_TE_HA_RECHAZADO_AL_PROYECTO + proyecto.getNombre() + Mensajes.POR_EL_SIGUIENTE_MOTIVO;

        this.personaRepositorioComando.eliminarRol(Rol.crear(TextoConstante.ROL_POSTULADO), postulacionDTO.getUsuarioID());
        this.postulacionRepositorioComando.actualizar(postulacion, postulacionDTO.getProyectoID(), postulacionDTO.getUsuarioID(), id);
        var respuestId = this.postulacionRepositorioComando.rechazarUsuario(motivoRechazoPostulacion, id);

        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return respuestId;
    }

    private void validarSiExistePostulacionConId(Long id) {
        if (ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id);
        }
    }
}