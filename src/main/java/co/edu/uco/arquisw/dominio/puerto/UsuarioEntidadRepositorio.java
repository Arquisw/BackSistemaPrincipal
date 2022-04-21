package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.UsuarioEntidad;
import java.util.List;

public interface UsuarioEntidadRepositorio
{
    List<UsuarioEntidad> consultar();
    UsuarioEntidad consultarPorCodigo(int codigo);
    void guardar(UsuarioEntidad usuarioEntidad);
    void actualizar(UsuarioEntidad usuarioEntidad, int codigo);
    void eliminar(int codigo);
    boolean existe(UsuarioEntidad usuarioEntidad);
}
