package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Ejecucion;

public interface EjecucionRepositorio
{
    Ejecucion consultarPorCodigo(int codigo);
    void guardar(Ejecucion ejecucion);
    void actualizar(Ejecucion ejecucion, int codigo);
    void eliminar(int codigo);
    boolean existe(Ejecucion ejecucion);
}
