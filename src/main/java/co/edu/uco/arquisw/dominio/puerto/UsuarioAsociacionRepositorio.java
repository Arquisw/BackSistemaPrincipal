package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.UsuarioAsociacion;
import java.util.List;

public interface UsuarioAsociacionRepositorio
{
    List<UsuarioAsociacion> consultar();
    UsuarioAsociacion consultarPorCodigo(int codigo);
    void guardar(UsuarioAsociacion usuarioAsociacion);
    void actualizar(UsuarioAsociacion usuarioAsociacion, int codigo);
    void eliminar(int codigo);
    boolean existe(UsuarioAsociacion usuarioAsociacion);
}
