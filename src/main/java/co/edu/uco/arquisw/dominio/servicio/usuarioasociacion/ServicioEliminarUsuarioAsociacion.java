package co.edu.uco.arquisw.dominio.servicio.usuarioasociacion;

import co.edu.uco.arquisw.dominio.puerto.UsuarioAsociacionRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarUsuarioAsociacion
{
    private static final String MENSAJE_EXISTE = "No existe un usuario entidad con el codigo ingresado";
    private final UsuarioAsociacionRepositorio usuarioAsociacionRepositorio;

    public ServicioEliminarUsuarioAsociacion(UsuarioAsociacionRepositorio usuarioAsociacionRepositorio)
    {
        this.usuarioAsociacionRepositorio = usuarioAsociacionRepositorio;
    }

    public void eliminar(int codigo)
    {
        if (this.usuarioAsociacionRepositorio.consultarPorCodigo(codigo) == null)
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        this.usuarioAsociacionRepositorio.eliminar(codigo);
    }
}