package co.edu.uco.arquisw.dominio.transversal.servicio.notificacion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;

import java.util.List;

public class ServicioNotificacionProyectoAprobadoRolLiderDeEquipo extends ServicioNotificacion {
    public ServicioNotificacionProyectoAprobadoRolLiderDeEquipo(ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
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

        if (seleccionDelProyecto.getRoles().contains(TextoConstante.ROL_DIRECTOR_PROYECTO)) {
            var asunto = Mensajes.PROYECTO_ACTUAL_APROBADO_POR_ROL_LIDER_DE_EQUIPO;
            var cuerpo = Mensajes.EL_PROYECTO + proyecto.getNombre() + Mensajes.HA_SIDO_APROBADO_POR_EL_ROL_LIDER_DE_EQUIPO;

            this.enviarNotificacion(correo, asunto, cuerpo);
        }
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