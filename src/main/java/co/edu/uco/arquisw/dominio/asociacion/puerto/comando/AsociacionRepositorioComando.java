package co.edu.uco.arquisw.dominio.asociacion.puerto.comando;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;

public interface AsociacionRepositorioComando {
    Long guardar(Asociacion asociacion, Long usuarioID);

    Long actualizar(Asociacion asociacion, Long id);

    void eliminar(Long id);

    void eliminarPorAdministrador(Long id);

    void crearNotificacionEliminacion(Long id);
}