package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.utilitario.UtilObjeto;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarUsuarioPorCorreoConClave
{
    private static final String MENSAJE_NO_EXISTE = "El usuario al que pertenece ese correo, no existe.";

    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioConsultarUsuarioPorCorreoConClave(UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario consultarPorCorreoConClave(String correo)
    {
        if(UtilObjeto.esNulo(this.usuarioRepositorio.consultarPorCorreo(correo)))
        {
            throw new IllegalArgumentException(MENSAJE_NO_EXISTE);
        }

        return this.usuarioRepositorio.consultarPorCorreoConClave(correo);
    }
}
