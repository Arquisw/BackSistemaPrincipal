package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.utilitario.UtilMensaje;
import co.edu.uco.arquisw.dominio.utilitario.UtilObjeto;
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
        this.usuarioRepositorio.actualizar(usuario, codigo);
    }

    private void verificarSiUsuarioExisteConCorreo(int codigo, Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorCorreo(usuario.getCorreo());

        if(!UtilObjeto.esNulo(usuarioResumen) && usuarioResumen.getCodigo() != codigo)
        {
            throw new IllegalArgumentException(UtilMensaje.YA_EXISTE_USUARIO_CON_CORREO);
        }
    }

    private void verificarSiUsuarioExisteConNumeroIdentificacion(int codigo, Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorNumeroIdentificacion(usuario.getNumeroIdentificacion());

        if(!UtilObjeto.esNulo(usuarioResumen) && usuarioResumen.getCodigo() != codigo)
        {
            throw new IllegalArgumentException(UtilMensaje.YA_EXISTE_USUARIO_CON_NUMERO_IDENTIFICACION);
        }
    }
}
