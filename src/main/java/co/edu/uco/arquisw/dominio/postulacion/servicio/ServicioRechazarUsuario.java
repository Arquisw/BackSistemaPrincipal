package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.MotivoRechazoPostulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;

public class ServicioRechazarUsuario {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;

    private final ServicioActualizarToken servicioActualizarToken;

    public ServicioRechazarUsuario(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando, ServicioActualizarToken servicioActualizarToken) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.postulacionRepositorioComando = postulacionRepositorioComando;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioActualizarToken = servicioActualizarToken;
    }

    public Long ejecutar(MotivoRechazoPostulacion motivoRechazoPostulacion, Long id) {
        validarSiExistePostulacionConId(id);

        var postulacionDTO = postulacionRepositorioConsulta.consultarPostulacionPorId(id);
        var postulacion = Postulacion.crear(postulacionDTO.getRoles(), false, true);

        this.personaRepositorioComando.eliminarRol(Rol.crear(TextoConstante.ROL_POSTULADO), postulacionDTO.getUsuarioID());
        this.postulacionRepositorioComando.actualizar(postulacion, postulacionDTO.getProyectoID(), postulacionDTO.getUsuarioID(), id);

        return this.postulacionRepositorioComando.rechazarUsuario(motivoRechazoPostulacion, id);
    }

    private void validarSiExistePostulacionConId(Long id) {
        if(ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id);
        }
    }
}
