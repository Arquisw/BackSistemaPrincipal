package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.FaseEjecucion;

public interface FaseEjecucionRepositorio
{
    FaseEjecucion consultarPorCodigo(int codigo);
    void guardar(FaseEjecucion faseEjecucion);
    void actualizar(FaseEjecucion faseEjecucion, int codigo);
    void eliminar(int codigo);
}