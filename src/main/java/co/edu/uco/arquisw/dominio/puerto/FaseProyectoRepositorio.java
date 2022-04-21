package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.FaseProyecto;

public interface FaseProyectoRepositorio
{
    FaseProyecto consultarPorCodigo(int codigo);
    void guardar(FaseProyecto faseProyecto);
    void actualizar(FaseProyecto faseProyecto, int codigo);
    void eliminar(int codigo);
}
