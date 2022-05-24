package co.edu.uco.arquisw.dominio.servicio.usuarioasociacion;

import co.edu.uco.arquisw.dominio.modelo.UsuarioAsociacion;
import co.edu.uco.arquisw.dominio.puerto.UsuarioAsociacionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioConsultarUsuarioAsociacion
{
    private final UsuarioAsociacionRepositorio usuarioAsociacionRepositorio;

    public ServicioConsultarUsuarioAsociacion(UsuarioAsociacionRepositorio usuarioAsociacionRepositorio)
    {
        this.usuarioAsociacionRepositorio = usuarioAsociacionRepositorio;
    }

    public List<UsuarioAsociacion> consultar()
    {
        return this.usuarioAsociacionRepositorio.consultar();
    }
}
