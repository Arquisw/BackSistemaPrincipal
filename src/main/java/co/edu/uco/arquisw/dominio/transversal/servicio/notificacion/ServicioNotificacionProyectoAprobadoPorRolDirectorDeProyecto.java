package co.edu.uco.arquisw.dominio.transversal.servicio.notificacion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;

public class ServicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto extends ServicioNotificacion {
    public ServicioNotificacionProyectoAprobadoPorRolDirectorDeProyecto(ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        super(servicioEnviarCorreoElectronico, necesidadRepositorioConsulta, asociacionRepositorioConsulta);
    }

    @Override
    public void notificar(String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConNecesidadId(Long necesidadId, String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConNecesidadIdYMotivoDeRechazo(Long necesidadId, String motivoRechazo, String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConProyectoIdYPorSeleccion(SeleccionDTO seleccionDelProyecto, Long proyectoId, String correo) {
        var proyecto = this.getNecesidadRepositorioConsulta().consultarProyectoPorId(proyectoId);
        var asunto = Mensajes.PROYECTO_ACTUAL_APROBADO_POR_ROL_DIRECTOR_DE_PROYECTO;
        var cuerpo = Mensajes.obtenerProyectoAprobadoPorRolDirectorDeProyecto(proyecto.getNombre());

        enviarNotificacion(correo, asunto, cuerpo);

    }

    @Override
    public void notificarConProyectoId(Long proyectoId, String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConProyectoIdYMotivoRechazo(Long proyectoId, String correo, String motivoRechazo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConAsociacionId(Long asociacionId, String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConUsuarioId(Long usuarioId, String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConCodigo(String codigo, String correo) {
        throw new UnsupportedOperationException();
    }
}