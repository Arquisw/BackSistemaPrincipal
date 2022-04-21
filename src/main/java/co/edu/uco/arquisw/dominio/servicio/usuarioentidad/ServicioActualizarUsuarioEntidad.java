package co.edu.uco.arquisw.dominio.servicio.usuarioentidad;

import co.edu.uco.arquisw.dominio.modelo.UsuarioEntidad;
import co.edu.uco.arquisw.dominio.puerto.UsuarioEntidadRepositorio;
import org.springframework.stereotype.Service;

public class ServicioActualizarUsuarioEntidad
{
    private static final String MENSAJE_EXISTE = "No existe un usuario entidad con el codigo indicado";

    private final UsuarioEntidadRepositorio usuarioEntidadRepositorio;

    public ServicioActualizarUsuarioEntidad(UsuarioEntidadRepositorio usuarioEntidadRepositorio)
    {
        this.usuarioEntidadRepositorio = usuarioEntidadRepositorio;
    }

    public void actualizar(int codigo, UsuarioEntidad usuarioEntidadModificado)
    {
        if(this.usuarioEntidadRepositorio.consultarPorCodigo(codigo) == null)
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        this.usuarioEntidadRepositorio.actualizar(usuarioEntidadModificado, codigo);
    }
}