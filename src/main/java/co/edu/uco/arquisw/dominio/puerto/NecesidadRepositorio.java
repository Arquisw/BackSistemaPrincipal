package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Necesidad;
import java.util.List;

public interface NecesidadRepositorio
{
    List<Necesidad> consultar();
    Necesidad consultarPorCodigo(int codigo);
    void guardar(Necesidad necesidad);
    void actualizar(Necesidad necesidad, int codigo);
    void eliminar(int codigo);
    boolean existe(Necesidad necesidad);
}