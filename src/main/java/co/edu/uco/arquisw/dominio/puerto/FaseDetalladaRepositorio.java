package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.FaseDetallada;

public interface FaseDetalladaRepositorio
{
    FaseDetallada consultarPorCodigo(int codigo);
    void guardar(FaseDetallada faseDetallada);
    void actualizar(FaseDetallada faseDetallada, int codigo);
    void eliminar(int codigo);
}