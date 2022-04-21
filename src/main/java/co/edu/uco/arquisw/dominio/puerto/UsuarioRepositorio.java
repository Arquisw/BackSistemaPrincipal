package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Usuario;
import java.util.List;

public interface UsuarioRepositorio
{
    List<Usuario> consultar();
    Usuario consultarPorCodigo(int codigo);
    Usuario consultarPorCorreo(String correo);
    Usuario consultarPorNumeroIdentificacion(String numeroIdentificacion);
    void guardar(Usuario usuario);
    void actualizar(Usuario usuario, int codigo);
    void eliminar(int codigo);
    boolean existe(Usuario usuario);
}