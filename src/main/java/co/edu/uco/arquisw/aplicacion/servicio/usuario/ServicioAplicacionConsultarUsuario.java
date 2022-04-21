package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.aplicacion.dto.PerfilDTO;
import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioConsultarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionConsultarUsuario
{
    private final ServicioConsultarUsuario servicioConsultarUsuario;

    public ServicioAplicacionConsultarUsuario(ServicioConsultarUsuario servicioConsultarUsuario)
    {
        this.servicioConsultarUsuario = servicioConsultarUsuario;
    }

    public UsuarioDTO consultarPorCodigo(int codigo)
    {
        return ensamblar(this.servicioConsultarUsuario.consultarPorCodigo(codigo));
    }

    private UsuarioDTO ensamblar(Usuario usuario)
    {
        return new UsuarioDTO(usuario.getCodigo(), usuario.getNombre(), usuario.getApellidos(), usuario.getNumeroIdentificacion(), usuario.getCorreo(), usuario.getClave(), usuario.getInstitucion(), new PerfilDTO(usuario.getPerfil().getCodigo(), usuario.getPerfil().getNombre()));
    }
}
