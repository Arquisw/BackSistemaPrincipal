package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.EstadoAsociacion;

public interface EstadoAsociacionRepositorio
{
    EstadoAsociacion consultarPorCodigo(int codigo);
    void guardar(EstadoAsociacion estadoAsociacion);
    void actualizar(EstadoAsociacion estadoAsociacion, int codigo);
    void eliminar(int codigo);
    boolean existe(EstadoAsociacion estadoAsociacion);
}
