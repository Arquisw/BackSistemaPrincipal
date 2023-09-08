package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioAprobarProyecto {
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;


    public ServicioAprobarProyecto(NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(Long id) throws MessagingException {
        validarSiExisteNecesidadConID(id);

        var necesidad = this.necesidadRepositorioConsulta.consultarPorNecesidadId(id);
        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(necesidad.getAsociacion());
        var correo = this.personaRepositorioConsulta.consultarPorId(asociacion.getUsuarioId()).getCorreo();
        var asunto = TextoConstante.PROYECTO_APROBADO_POR_EL_ADMINISTRADOR_ASUNTO;
        var cuerpo = TextoConstante.EL_PROYECTO + necesidad.getProyecto().getNombre() +  TextoConstante.HA_SIDO_APROBADO_POR_EL_ADMINISTRADOR;

        var respuestaId = this.necesidadRepositorioComando.actualizarEstadoNecesidad(EstadoNecesidad.crear(TextoConstante.ESTADO_APROBADO), id);
        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return respuestaId;
    }

    private void validarSiExisteNecesidadConID(Long id) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + id);
        }
    }
}