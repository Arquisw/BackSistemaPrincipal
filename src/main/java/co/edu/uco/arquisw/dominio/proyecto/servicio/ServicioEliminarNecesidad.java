package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioEliminarNecesidad {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;

    public ServicioEliminarNecesidad(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(Long id) throws MessagingException {
        validarSiExisteNecesidadConID(id);
        validarSiPuedeEliminarLaCuenta(id);

        var necesidad = this.necesidadRepositorioConsulta.consultarPorNecesidadId(id);
        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(necesidad.getAsociacion());
        var correo = this.personaRepositorioConsulta.consultarPorId(asociacion.getUsuarioId()).getCorreo();
        var asunto = TextoConstante.PROYECTO_DE_LA_ASOCIACION_DE_TU_CUENTA_DE_ARQUISWQ_ELIMINADA_ASUNTO;
        var cuerpo = TextoConstante.EL_PROYECTO + necesidad.getProyecto().getNombre() +  TextoConstante.HA_SIDO_ELIMINADO_PROYECTO_POR_TI;

        this.necesidadRepositorioComando.eliminar(id);
        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return id;
    }

    private void validarSiExisteNecesidadConID(Long id) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + id);
        }
    }

    private void validarSiPuedeEliminarLaCuenta(Long id) {
        var necesidad = this.necesidadRepositorioConsulta.consultarPorNecesidadId(id);

        if(necesidad.getEstado().getNombre().equals(TextoConstante.ESTADO_APROBADO) || necesidad.getEstado().getNombre().equals(TextoConstante.ESTADO_NEGOCIADO)) {
            this.necesidadRepositorioComando.crearNotificacionEliminacion(necesidad.getId());
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_APROBADA_PARA_SU_DESARROLLO);
        }
    }
}