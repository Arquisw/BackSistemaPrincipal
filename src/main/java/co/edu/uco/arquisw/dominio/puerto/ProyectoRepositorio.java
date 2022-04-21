package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Proyecto;
import java.util.List;

public interface ProyectoRepositorio
{
    List<Proyecto> consultar();
    Proyecto consultarPorCodigo(int codigo);
    void guardar(Proyecto proyecto);
    void actualizar(Proyecto proyecto, int codigo);
    void eliminar(int codigo);
    boolean existe(Proyecto proyecto);
}
