package co.edu.uco.arquisw.dominio.transversal.servicio.notificacion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;

import java.util.List;

public class ServicioNotificacionProyectoAprobado extends ServicioNotificacion {
    public ServicioNotificacionProyectoAprobado(ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        super(servicioEnviarCorreoElectronico, necesidadRepositorioConsulta, asociacionRepositorioConsulta);
    }

    @Override
    public void notificar(String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConNecesidadId(Long necesidadId, String correo) {
        var necesidad = this.getNecesidadRepositorioConsulta().consultarPorNecesidadId(necesidadId);
        var asunto = Mensajes.PROYECTO_APROBADO_POR_EL_ADMINISTRADOR_ASUNTO;
        var cuerpo = Mensajes.EL_PROYECTO + necesidad.getProyecto().getNombre() + Mensajes.HA_SIDO_APROBADO_POR_EL_ADMINISTRADOR;

        this.enviarNotificacion(correo, asunto, cuerpo);
    }

    @Override
    public void notificarConNecesidadIdYMotivoDeRechazo(Long necesidadId, String motivoRechazo, String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConProyectoIdYPorSeleccion(SeleccionDTO seleccionDelProyecto, Long proyectoId, String correo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notificarConProyectoId(Long proyectoId, String correo) {
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