package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.validador.ValidarObjeto;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarUsuario 
{
    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioModificarUsuario(UsuarioRepositorio usuarioRepositorio) 
    {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public void modificar(int codigo, Usuario usuario) 
    {
        verificarSiUsuarioExisteConCorreo(codigo, usuario);
        verificarSiUsuarioExisteConNumeroIdentificacion(codigo, usuario);

        this.usuarioRepositorio.actualizar(usuario, codigo);
    }

    private void verificarSiUsuarioExisteConCorreo(int codigo, Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorCorreo(usuario.getCorreo());

        if(!ValidarObjeto.esNulo(usuarioResumen) && usuarioResumen.getCodigo() != codigo)
        {
            throw new IllegalArgumentException(Mensajes.YA_EXISTE_USUARIO_CON_CORREO);
        }
    }

    private void verificarSiUsuarioExisteConNumeroIdentificacion(int codigo, Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorNumeroIdentificacion(usuario.getNumeroIdentificacion());

        if(!ValidarObjeto.esNulo(usuarioResumen) && usuarioResumen.getCodigo() != codigo)
        {
            throw new IllegalArgumentException(Mensajes.YA_EXISTE_USUARIO_CON_NUMERO_IDENTIFICACION);
        }
    }
}
