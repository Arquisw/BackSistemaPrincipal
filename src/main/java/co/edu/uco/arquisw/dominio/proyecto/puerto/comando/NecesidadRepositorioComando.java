package co.edu.uco.arquisw.dominio.proyecto.puerto.comando;

import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;

public interface NecesidadRepositorioComando {
    Long guardar(Necesidad necesidad, Long asociacionID);
    Long actualizar(Necesidad necesidad, Long asociacionID);
    Long actualizarEstadoNecesidad(EstadoNecesidad estadoNecesidad, Long necesidadID);
    void actualizarEstadoProyecto(EstadoProyecto estadoProyecto, Long proyectoID);
    void eliminar(Long id);
    void crearNotificacionEliminacion(Long id);
    Long actualizarAprobacionProyecto(Long proyectoID, String rol);
}