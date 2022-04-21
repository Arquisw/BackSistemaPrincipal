package co.edu.uco.arquisw.dominio.servicio.usuarioentidad;

import co.edu.uco.arquisw.dominio.puerto.UsuarioEntidadRepositorio;
import org.springframework.stereotype.Service;

public class ServicioEliminarUsuarioEntidad
{
    private static final String MENSAJE_EXISTE = "No existe un usuario entidad con el codigo ingresado";
    private final UsuarioEntidadRepositorio usuarioEntidadRepositorio;

    public ServicioEliminarUsuarioEntidad(UsuarioEntidadRepositorio usuarioEntidadRepositorio)
    {
        this.usuarioEntidadRepositorio = usuarioEntidadRepositorio;
    }

    public void eliminar(int codigo)
    {
        if (this.usuarioEntidadRepositorio.consultarPorCodigo(codigo) == null)
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        this.usuarioEntidadRepositorio.eliminar(codigo);
    }
}