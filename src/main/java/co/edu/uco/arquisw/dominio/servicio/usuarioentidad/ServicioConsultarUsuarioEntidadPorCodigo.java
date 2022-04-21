package co.edu.uco.arquisw.dominio.servicio.usuarioentidad;

import co.edu.uco.arquisw.dominio.modelo.UsuarioEntidad;
import co.edu.uco.arquisw.dominio.puerto.UsuarioEntidadRepositorio;
import org.springframework.stereotype.Service;

public class ServicioConsultarUsuarioEntidadPorCodigo
{
    private static final String MENSAJE_EXISTE = "No existe un usuario entidad con el codigo indicado";

    private final UsuarioEntidadRepositorio usuarioEntidadRepositorio;

    public ServicioConsultarUsuarioEntidadPorCodigo(UsuarioEntidadRepositorio usuarioEntidadRepositorio)
    {
        this.usuarioEntidadRepositorio = usuarioEntidadRepositorio;
    }

    public UsuarioEntidad consultarPorCodigo(int codigo)
    {
        UsuarioEntidad usuarioEntidad= this.usuarioEntidadRepositorio.consultarPorCodigo(codigo);
        if(usuarioEntidad==null)
        {
           throw new IllegalArgumentException(MENSAJE_EXISTE);
        }
        return usuarioEntidad;
    }
}
