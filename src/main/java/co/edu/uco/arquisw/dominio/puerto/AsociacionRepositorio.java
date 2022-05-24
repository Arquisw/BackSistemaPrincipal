package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Asociacion;
import java.util.List;

public interface AsociacionRepositorio
{
    List<Asociacion> consultar();
    Asociacion consultarPorCodigo(int codigo);
    Asociacion consultarPorNIT(String nit);
    void guardar(Asociacion asociacion);
    void actualizar(Asociacion asociacion, int codigo);
    void eliminar(int codigo);
    boolean existe(Asociacion asociacion);
}
