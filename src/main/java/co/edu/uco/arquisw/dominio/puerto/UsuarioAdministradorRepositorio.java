package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.UsuarioAdministrador;
import java.util.List;

public interface UsuarioAdministradorRepositorio
{
    List<UsuarioAdministrador> consultar();
    UsuarioAdministrador consultarPorCodigo(int codigo);
    void guardar(UsuarioAdministrador usuarioAdministrador);
    void actualizar(UsuarioAdministrador usuarioAdministrador, int codigo);
    void eliminar(int codigo);
    boolean existe(UsuarioAdministrador usuarioAdministrador);
}
