package co.edu.uco.arquisw.dominio.servicio.usuarioasociacion;

import co.edu.uco.arquisw.dominio.modelo.UsuarioAsociacion;
import co.edu.uco.arquisw.dominio.puerto.UsuarioAsociacionRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarUsuarioAsociacion
{
    private static final String MENSAJE_EXISTE = "No existe un usuario entidad con el codigo indicado";

    private final UsuarioAsociacionRepositorio usuarioAsociacionRepositorio;

    public ServicioActualizarUsuarioAsociacion(UsuarioAsociacionRepositorio usuarioAsociacionRepositorio)
    {
        this.usuarioAsociacionRepositorio = usuarioAsociacionRepositorio;
    }

    public void actualizar(int codigo, UsuarioAsociacion usuarioAsociacionModificado)
    {
        if(this.usuarioAsociacionRepositorio.consultarPorCodigo(codigo) == null)
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        this.usuarioAsociacionRepositorio.actualizar(usuarioAsociacionModificado, codigo);
    }
}