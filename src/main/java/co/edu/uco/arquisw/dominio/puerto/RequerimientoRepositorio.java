package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Requerimiento;
import java.util.List;

public interface RequerimientoRepositorio
{
    List<Requerimiento> consultar();
    Requerimiento consultarPorCodigo(int codigo);
    void guardar(Requerimiento requerimiento);
    void actualizar(Requerimiento requerimiento, int codigo);
    void eliminar(int codigo);
    boolean existe(Requerimiento requerimiento);
}
