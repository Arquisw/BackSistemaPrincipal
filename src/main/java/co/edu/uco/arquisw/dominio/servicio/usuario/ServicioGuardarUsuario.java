package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.PerfilRepositorio;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.validador.ValidarObjeto;
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
        verificarSiUsuarioExisteConCorreo(usuario);
        verificarSiUsuarioExisteConNumeroIdentificacion(usuario);

        this.perfilRepositorio.guardar(Perfil.crear(1, "ROLE_USER"));
        this.usuarioRepositorio.guardar(usuario);
    }

    private void verificarSiUsuarioExisteConCorreo(Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorCorreo(usuario.getCorreo());

        if(!ValidarObjeto.esNulo(usuarioResumen))
        {
            throw new IllegalArgumentException(Mensajes.YA_EXISTE_USUARIO_CON_CORREO);
        }
    }

    private void verificarSiUsuarioExisteConNumeroIdentificacion(Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorNumeroIdentificacion(usuario.getNumeroIdentificacion());

        if(!ValidarObjeto.esNulo(usuarioResumen))
        {
            throw new IllegalArgumentException(Mensajes.YA_EXISTE_USUARIO_CON_NUMERO_IDENTIFICACION);
        }
    }
}
