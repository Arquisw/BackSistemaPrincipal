package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Rol;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioModificarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarUsuario
{
    private final ServicioModificarUsuario servicioModificarUsuario;

    public ServicioAplicacionModificarUsuario(ServicioModificarUsuario servicioModificarUsuario)
    {
        this.servicioModificarUsuario = servicioModificarUsuario;
    }

    public void modificar(int codigo, UsuarioDTO usuarioDTO)
    {
        var usuario = Usuario.crear(usuarioDTO.getCodigo(), usuarioDTO.getNombre(), usuarioDTO.getApellidos(), usuarioDTO.getNumeroIdentificacion(), usuarioDTO.getCorreo(), usuarioDTO.getClave(), usuarioDTO.getInstitucion(), Perfil.crear(usuarioDTO.getPerfil().getCodigo(), usuarioDTO.getPerfil().getNombre()));

        this.servicioModificarUsuario.modificar(codigo, usuario);
    }
}