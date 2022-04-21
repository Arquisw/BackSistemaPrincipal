package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.PerfilRepositorio;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.utilitario.UtilMensaje;
import co.edu.uco.arquisw.dominio.utilitario.UtilObjeto;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarUsuario
{
    private final UsuarioRepositorio usuarioRepositorio;
    private final PerfilRepositorio perfilRepositorio;

    public ServicioGuardarUsuario(UsuarioRepositorio usuarioRepositorio, PerfilRepositorio perfilRepositorio)
    {
        this.usuarioRepositorio = usuarioRepositorio;
        this.perfilRepositorio = perfilRepositorio;
    }

    public void guardar(Usuario usuario)
    {
        verificarSiPerfilExiste(usuario.getPerfil());
        verificarSiUsuarioExisteConCorreo(usuario);
        verificarSiUsuarioExisteConNumeroIdentificacion(usuario);

        this.usuarioRepositorio.guardar(usuario);
    }

    private void verificarSiPerfilExiste(Perfil perfil)
    {
        if(!this.perfilRepositorio.existe(perfil))
        {
            throw new IllegalArgumentException(UtilMensaje.NO_EXISTE_PERFIL_CON_NOMBRE);
        }
    }

    private void verificarSiUsuarioExisteConCorreo(Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorCorreo(usuario.getCorreo());

        if(!UtilObjeto.esNulo(usuarioResumen))
        {
            throw new IllegalArgumentException(UtilMensaje.YA_EXISTE_USUARIO_CON_CORREO);
        }
    }

    private void verificarSiUsuarioExisteConNumeroIdentificacion(Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorNumeroIdentificacion(usuario.getNumeroIdentificacion());

        if(!UtilObjeto.esNulo(usuarioResumen))
        {
            throw new IllegalArgumentException(UtilMensaje.YA_EXISTE_USUARIO_CON_NUMERO_IDENTIFICACION);
        }
    }
}
