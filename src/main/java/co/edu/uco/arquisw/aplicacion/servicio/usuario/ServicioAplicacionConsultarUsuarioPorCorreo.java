package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.aplicacion.dto.PerfilDTO;
import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioConsultarUsuarioPorCorreo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionConsultarUsuarioPorCorreo
{
    private final ServicioConsultarUsuarioPorCorreo servicioConsultarUsuarioPorCorreo;

    public ServicioAplicacionConsultarUsuarioPorCorreo(ServicioConsultarUsuarioPorCorreo servicioConsultarUsuarioPorCorreo)
    {
        this.servicioConsultarUsuarioPorCorreo = servicioConsultarUsuarioPorCorreo;
    }

    public UsuarioDTO consultarPorCorreo(String correo)
    {
        return ensamblar(this.servicioConsultarUsuarioPorCorreo.consultarPorCorreo(correo));
    }

    private UsuarioDTO ensamblar(Usuario usuario)
    {
        return new UsuarioDTO(usuario.getCodigo(), usuario.getNombre(), usuario.getApellidos(), usuario.getNumeroIdentificacion(), usuario.getCorreo(), usuario.getClave(), usuario.getInstitucion(), new PerfilDTO(usuario.getPerfil().getCodigo(), usuario.getPerfil().getNombre()));
    }
}
