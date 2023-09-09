package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioEliminarPersona {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;

    public ServicioEliminarPersona(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PostulacionRepositorioConsulta postulacionRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(Long id) throws MessagingException {
        validarSiNoExisteUsuarioConId(id);
        validarSiPuedeEliminarLaCuenta(id);

        var correo = this.personaRepositorioConsulta.consultarPorId(id).getCorreo();
        var asunto = Mensajes.CUENTA_DE_ARQUISQ_ELIMINADA_ASUNTO;
        var cuerpo = Mensajes.TU_CUENTA_HA_SIDO_ELIMINADA_DE_FORMA_DEFINITIVA_POR_TI;

        this.personaRepositorioComando.eliminar(id);
        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return id;
    }

    private void validarSiNoExisteUsuarioConId(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }

    private void validarSiPuedeEliminarLaCuenta(Long id) {
        if (!ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorIDUsuario(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_ASOCIACION_A_CARGO);
        }

        if (!ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarSeleccionesPorUsuarioId(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_SELECCIONADO_EN_UN_PROYECTO);
        }

        if (!ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionesPorUsuarioId(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_EN_UN_PROCESO_DE_POSTULACION);
        }

    }
}