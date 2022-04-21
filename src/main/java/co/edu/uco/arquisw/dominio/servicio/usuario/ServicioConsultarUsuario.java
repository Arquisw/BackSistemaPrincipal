package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarUsuario
{
    private static final String MENSAJE_NO_EXISTE = "El usuario al que pertenece ese codigo, no existe.";

    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioConsultarUsuario(UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario consultarPorCodigo(int codigo)
    {
        if(!this.usuarioRepositorio.existe(this.usuarioRepositorio.consultarPorCodigo(codigo)))
        {
            throw new IllegalArgumentException(MENSAJE_NO_EXISTE);
        }
        return this.usuarioRepositorio.consultarPorCodigo(codigo);
    }
}
