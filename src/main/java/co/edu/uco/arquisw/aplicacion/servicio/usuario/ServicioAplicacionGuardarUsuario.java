package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Rol;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarUsuario
{
    private final ServicioGuardarUsuario servicioGuardarUsuario;

    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario)
    {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
    }

    public void guardar(UsuarioDTO usuarioDTO)
    {
        var usuario = Usuario.crear(usuarioDTO.getCodigo(), usuarioDTO.getNombre(), usuarioDTO.getApellidos(), usuarioDTO.getNumeroIdentificacion(), usuarioDTO.getCorreo(), usuarioDTO.getClave(), usuarioDTO.getInstitucion(), Perfil.crear(usuarioDTO.getPerfil().getCodigo(), usuarioDTO.getPerfil().getNombre()));

        this.servicioGuardarUsuario.guardar(usuario);
    }
}