package co.edu.uco.arquisw.dominio.transversal.servicio.notificacion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import lombok.Getter;

import javax.mail.MessagingException;

@Getter
public abstract class ServicioNotificacion {
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    protected ServicioNotificacion(ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }

    public abstract void notificar(String correo);

    public abstract void notificarConNecesidadId(Long necesidadId, String correo);

    public abstract void notificarConNecesidadIdYMotivoDeRechazo(Long necesidadId, String motivoRechazo, String correo);

    public abstract void notificarConProyectoIdYPorSeleccion(SeleccionDTO seleccionDelProyecto, Long proyectoId, String correo);

    public abstract void notificarConProyectoId(Long proyectoId, String correo);

    public abstract void notificarConProyectoIdYMotivoRechazo(Long proyectoId, String correo, String motivoRechazo);

    public abstract void notificarConAsociacionId(Long asociacionId, String correo);

    public abstract void notificarConUsuarioId(Long usuarioId, String correo);

    public abstract void notificarConCodigo(String codigo, String correo);

    public void enviarNotificacion(String correo, String asunto, String cuerpo) {
        try {
            this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);
        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}