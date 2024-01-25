package co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.enumerador.TipoNotificacion;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;


public class ServicioNotificacionFactoria {
    private final ServicioNotificacionActivacionCuentaIniciada servicioNotificacionActivacionCuentaIniciada;
    private final ServicioNotificacionAsociacionEliminada servicioNotificacionAsociacionEliminada;
    private final ServicioNotificacionAsociacionEliminadaPorAdministrador servicioNotificacionAsociacionEliminadaPorAdministrador;
    private final ServicioNotificacionContratoActualizado servicioNotificacionContratoActualizado;
    private final ServicioNotificacionContratoGuardado servicioNotificacionContratoGuardado;
    private final ServicioNotificacionNecesidadEliminada servicioNotificacionNecesidadEliminada;
    private final ServicioNotificacionNecesidadEliminadaPorAdministrador servicioNotificacionNecesidadEliminadaPorAdministrador;
    private final ServicioNotificacionPersonaEliminada servicioNotificacionPersonaEliminada;
    private final ServicioNotificacionPersonaEliminadaPorAdministrador servicioNotificacionPersonaEliminadaPorAdministrador;
    private final ServicioNotificacionProyectoAprobado servicioNotificacionProyectoAprobado;
    private final ServicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto servicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto;
    private final ServicioNotificacionProyectoAprobadoRolIngenieria servicioNotificacionProyectoAprobadoRolIngenieria;
    private final ServicioNotificacionProyectoAprobadoRolLiderDeEquipo servicioNotificacionProyectoAprobadoRolLiderDeEquipo;
    private final ServicioNotificacionProyectoRechazado servicioNotificacionProyectoRechazado;
    private final ServicioNotificacionRecuperacionClaveIniciada servicioNotificacionRecuperacionClaveIniciada;
    private final ServicioNotificacionUsuarioRechazado servicioNotificacionUsuarioRechazado;
    private final ServicioNotificacionUsuarioSeleccionado servicioNotificacionUsuarioSeleccionado;

    public ServicioNotificacionFactoria(ServicioNotificacionActivacionCuentaIniciada servicioNotificacionActivacionCuentaIniciada, ServicioNotificacionAsociacionEliminada servicioNotificacionAsociacionEliminada, ServicioNotificacionAsociacionEliminadaPorAdministrador servicioNotificacionAsociacionEliminadaPorAdministrador, ServicioNotificacionContratoActualizado servicioNotificacionContratoActualizado, ServicioNotificacionContratoGuardado servicioNotificacionContratoGuardado, ServicioNotificacionNecesidadEliminada servicioNotificacionNecesidadEliminada, ServicioNotificacionNecesidadEliminadaPorAdministrador servicioNotificacionNecesidadEliminadaPorAdministrador, ServicioNotificacionPersonaEliminada servicioNotificacionPersonaEliminada, ServicioNotificacionPersonaEliminadaPorAdministrador servicioNotificacionPersonaEliminadaPorAdministrador, ServicioNotificacionProyectoAprobado servicioNotificacionProyectoAprobado, ServicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto servicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto, ServicioNotificacionProyectoAprobadoRolIngenieria servicioNotificacionProyectoAprobadoRolIngenieria, ServicioNotificacionProyectoAprobadoRolLiderDeEquipo servicioNotificacionProyectoAprobadoRolLiderDeEquipo, ServicioNotificacionProyectoRechazado servicioNotificacionProyectoRechazado, ServicioNotificacionRecuperacionClaveIniciada servicioNotificacionRecuperacionClaveIniciada, ServicioNotificacionUsuarioRechazado servicioNotificacionUsuarioRechazado, ServicioNotificacionUsuarioSeleccionado servicioNotificacionUsuarioSeleccionado) {
        this.servicioNotificacionActivacionCuentaIniciada = servicioNotificacionActivacionCuentaIniciada;
        this.servicioNotificacionAsociacionEliminada = servicioNotificacionAsociacionEliminada;
        this.servicioNotificacionAsociacionEliminadaPorAdministrador = servicioNotificacionAsociacionEliminadaPorAdministrador;
        this.servicioNotificacionContratoActualizado = servicioNotificacionContratoActualizado;
        this.servicioNotificacionContratoGuardado = servicioNotificacionContratoGuardado;
        this.servicioNotificacionNecesidadEliminada = servicioNotificacionNecesidadEliminada;
        this.servicioNotificacionNecesidadEliminadaPorAdministrador = servicioNotificacionNecesidadEliminadaPorAdministrador;
        this.servicioNotificacionPersonaEliminada = servicioNotificacionPersonaEliminada;
        this.servicioNotificacionPersonaEliminadaPorAdministrador = servicioNotificacionPersonaEliminadaPorAdministrador;
        this.servicioNotificacionProyectoAprobado = servicioNotificacionProyectoAprobado;
        this.servicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto = servicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto;
        this.servicioNotificacionProyectoAprobadoRolIngenieria = servicioNotificacionProyectoAprobadoRolIngenieria;
        this.servicioNotificacionProyectoAprobadoRolLiderDeEquipo = servicioNotificacionProyectoAprobadoRolLiderDeEquipo;
        this.servicioNotificacionProyectoRechazado = servicioNotificacionProyectoRechazado;
        this.servicioNotificacionRecuperacionClaveIniciada = servicioNotificacionRecuperacionClaveIniciada;
        this.servicioNotificacionUsuarioRechazado = servicioNotificacionUsuarioRechazado;
        this.servicioNotificacionUsuarioSeleccionado = servicioNotificacionUsuarioSeleccionado;
    }

    @Async
    @Transactional
    public void orquestarNotificacion(TipoNotificacion tipoNotificacion, Long proyectoId, Long necesidadId, Long usuarioId, Long asociacionId, String codigo, String motivoRechazo, String correo, SeleccionDTO seleccionDelProyecto) {
        switch (tipoNotificacion) {
            case CONTRATO_ACTUALIZADO -> this.servicioNotificacionContratoActualizado.notificarConNecesidadId(necesidadId, correo);
            case CONTRATO_GUARDADO -> this.servicioNotificacionContratoGuardado.notificarConNecesidadId(necesidadId, correo);
            case PROYECTO_APROBADO -> this.servicioNotificacionProyectoAprobado.notificarConNecesidadId(necesidadId, correo);
            case NECESIDAD_ELIMINADA -> this.servicioNotificacionNecesidadEliminada.notificarConNecesidadId(necesidadId, correo);
            case NECESIDAD_ELIMINADA_POR_ADMINISTRADOR -> this.servicioNotificacionNecesidadEliminadaPorAdministrador.notificarConNecesidadId(necesidadId, correo);
            case PROYECTO_RECHAZADO -> this.servicioNotificacionProyectoRechazado.notificarConNecesidadIdYMotivoDeRechazo(necesidadId, motivoRechazo, correo);
            case USUARIO_RECHAZADO -> this.servicioNotificacionUsuarioRechazado.notificarConProyectoIdYMotivoRechazo(proyectoId, correo, motivoRechazo);
            case USUARIO_SELECCIONADO -> this.servicioNotificacionUsuarioSeleccionado.notificarConProyectoId(proyectoId, correo);
            case PROYECTO_APROBADO_POR_ROL_DIRECTOR_DE_PROYECTO -> this.servicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto.notificarConProyectoIdYPorSeleccion(seleccionDelProyecto, proyectoId, correo);
            case PROYECTO_APROBADO_POR_ROL_INGENIERIA -> this.servicioNotificacionProyectoAprobadoRolIngenieria.notificarConProyectoIdYPorSeleccion(seleccionDelProyecto,proyectoId, correo);
            case PROYECTO_APROBADO_POR_LIDER_DE_EQUIPO -> this.servicioNotificacionProyectoAprobadoRolLiderDeEquipo.notificarConProyectoIdYPorSeleccion(seleccionDelProyecto,proyectoId, correo);
            case ASOCIACION_ELIMINADA -> this.servicioNotificacionAsociacionEliminada.notificarConUsuarioId(usuarioId, correo);
            case ASOCIACION_ELIMINADA_POR_ADMINISTRADOR -> this.servicioNotificacionAsociacionEliminadaPorAdministrador.notificarConAsociacionId(asociacionId, correo);
            case ACTIVACION_CUENTA_INICIADA -> this.servicioNotificacionActivacionCuentaIniciada.notificarConCodigo(codigo, correo);
            case RECUPERACION_CLAVE_INICIADA -> this.servicioNotificacionRecuperacionClaveIniciada.notificarConCodigo(codigo, correo);
            case PERSONA_ELIMINADA -> this.servicioNotificacionPersonaEliminada.notificar(correo);
            case PERSONA_ELIMINADA_POR_ADMINISTRADOR -> this.servicioNotificacionPersonaEliminadaPorAdministrador.notificar(correo);
        }
    }
}