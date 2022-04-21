package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.UsuarioPostulacion;
import java.util.List;

public interface UsuarioPostulacionRepositorio
{
    List<UsuarioPostulacion> consultar();
    UsuarioPostulacion consultarPorCodigo(int codigo);
    void guardar(UsuarioPostulacion usuarioPostulado);
    void actualizar(UsuarioPostulacion usuarioPostulado, int codigo);
    void eliminar(int codigo);
    boolean existe(UsuarioPostulacion usuarioPostulado);
}
