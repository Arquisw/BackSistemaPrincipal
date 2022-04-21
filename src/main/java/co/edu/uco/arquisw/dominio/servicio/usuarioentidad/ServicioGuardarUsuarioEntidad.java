package co.edu.uco.arquisw.dominio.servicio.usuarioentidad;

import co.edu.uco.arquisw.dominio.modelo.UsuarioEntidad;
import co.edu.uco.arquisw.dominio.puerto.UsuarioEntidadRepositorio;
import org.springframework.stereotype.Service;

public class ServicioGuardarUsuarioEntidad
{
    private static final String MENSAJE_EXISTE = "Existe un usuario entidad con los datos ingresada";
    private final UsuarioEntidadRepositorio usuarioEntidadRepositorio;

    public ServicioGuardarUsuarioEntidad(UsuarioEntidadRepositorio usuarioEntidadRepositorio)
    {
        this.usuarioEntidadRepositorio = usuarioEntidadRepositorio;
    }

    public void guardar(UsuarioEntidad usuarioEntidad)
    {
        if (this.usuarioEntidadRepositorio.existe(usuarioEntidad))
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        this.usuarioEntidadRepositorio.guardar(usuarioEntidad);
    }
}