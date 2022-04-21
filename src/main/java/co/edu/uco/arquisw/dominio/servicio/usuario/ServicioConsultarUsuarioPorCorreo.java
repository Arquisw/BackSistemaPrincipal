package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarUsuarioPorCorreo
{
    private static final String MENSAJE_NO_EXISTE = "El usuario al que pertenece ese correo, no existe.";

    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioConsultarUsuarioPorCorreo(UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario consultarPorCorreo(String correo)
    {
        if(!this.usuarioRepositorio.existe(this.usuarioRepositorio.consultarPorCorreo(correo)))
        {
            throw new IllegalArgumentException(MENSAJE_NO_EXISTE);
        }
        return this.usuarioRepositorio.consultarPorCorreo(correo);
    }
}
