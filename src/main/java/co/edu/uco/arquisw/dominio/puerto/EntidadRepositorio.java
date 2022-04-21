package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Entidad;
import java.util.List;

public interface EntidadRepositorio
{
    List<Entidad> consultar();
    Entidad consultarPorCodigo(int codigo);
    void guardar(Entidad entidad);
    void actualizar(Entidad entidad, int codigo);
    void eliminar(int codigo);
    boolean existe(Entidad entidad);
}
