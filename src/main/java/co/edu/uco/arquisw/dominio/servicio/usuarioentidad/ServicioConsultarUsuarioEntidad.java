package co.edu.uco.arquisw.dominio.servicio.usuarioentidad;

import co.edu.uco.arquisw.dominio.modelo.UsuarioEntidad;
import co.edu.uco.arquisw.dominio.puerto.UsuarioEntidadRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

public class ServicioConsultarUsuarioEntidad
{
    private final UsuarioEntidadRepositorio usuarioEntidadRepositorio;

    public ServicioConsultarUsuarioEntidad(UsuarioEntidadRepositorio usuarioEntidadRepositorio)
    {
        this.usuarioEntidadRepositorio = usuarioEntidadRepositorio;
    }

    public List<UsuarioEntidad> consultar()
    {
        return this.usuarioEntidadRepositorio.consultar();
    }
}
