package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Postulacion;
import java.util.List;

public interface PostulacionRepositorio
{
    List<Postulacion> consultar();
    Postulacion consultarPorCodigo(int codigo);
    void guardar(Postulacion postulacion);
    void eliminar(int codigo);
    boolean existe(Postulacion postulacion);
}