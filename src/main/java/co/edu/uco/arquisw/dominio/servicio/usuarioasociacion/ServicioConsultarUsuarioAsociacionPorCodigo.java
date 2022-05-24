package co.edu.uco.arquisw.dominio.servicio.usuarioasociacion;

import co.edu.uco.arquisw.dominio.modelo.UsuarioAsociacion;
import co.edu.uco.arquisw.dominio.puerto.UsuarioAsociacionRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarUsuarioAsociacionPorCodigo
{
    private static final String MENSAJE_EXISTE = "No existe un usuario entidad con el codigo indicado";

    private final UsuarioAsociacionRepositorio usuarioAsociacionRepositorio;

    public ServicioConsultarUsuarioAsociacionPorCodigo(UsuarioAsociacionRepositorio usuarioAsociacionRepositorio)
    {
        this.usuarioAsociacionRepositorio = usuarioAsociacionRepositorio;
    }

    public UsuarioAsociacion consultarPorCodigo(int codigo)
    {
        UsuarioAsociacion usuarioAsociacion = this.usuarioAsociacionRepositorio.consultarPorCodigo(codigo);
        if(usuarioAsociacion ==null)
        {
           throw new IllegalArgumentException(MENSAJE_EXISTE);
        }
        return usuarioAsociacion;
    }
}
