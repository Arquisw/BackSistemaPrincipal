package co.edu.uco.arquisw.dominio.proyecto.puerto.comando;

import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Requerimientos;

public interface NecesidadRepositorioComando {
    Long guardar(Necesidad necesidad, Long asociacionID);
    Long guardarRequerimientos(Requerimientos requerimientos, Long necesidadID);
    Long actualizar(Necesidad necesidad, Long asociacionID);
    Long actualizarRequerimientos(Requerimientos requerimientos, Long necesidadID);
    Long actualizarEstadoNecesidad(EstadoNecesidad estadoNecesidad, Long necesidadID);
    void actualizarEstadoProyecto(EstadoProyecto estadoProyecto, Long proyectoID);
    void eliminar(Long id);
    void eliminarPorAdministrador(Long id);
    void crearNotificacionEliminacion(Long id);
    Long actualizarAprobacionProyecto(Long proyectoID, String rol);
}