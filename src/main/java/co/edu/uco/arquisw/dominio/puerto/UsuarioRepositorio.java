package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import java.util.List;

public interface UsuarioRepositorio
{
    List<UsuarioResumenDTO> consultar();
    UsuarioResumenDTO consultarPorCodigo(int codigo);
    UsuarioResumenDTO consultarPorCorreo(String correo);
    Usuario consultarPorCorreoConClave(String correo);
    UsuarioResumenDTO consultarPorNumeroIdentificacion(String numeroIdentificacion);
    void guardar(Usuario usuario);
    void actualizar(Usuario usuario, int codigo);
    void eliminar(int codigo);
    boolean existe(Usuario usuario);
}