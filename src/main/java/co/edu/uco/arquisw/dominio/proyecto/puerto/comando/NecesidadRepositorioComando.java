package co.edu.uco.arquisw.dominio.proyecto.puerto.comando;

import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;

public interface NecesidadRepositorioComando
{
    Long guardar(Necesidad necesidad, Long asociacionID);
    Long actualizar(Necesidad necesidad, Long asociacionID);
    void eliminar(Long id);
    void crearNotificacionEliminacion(Long id);
}