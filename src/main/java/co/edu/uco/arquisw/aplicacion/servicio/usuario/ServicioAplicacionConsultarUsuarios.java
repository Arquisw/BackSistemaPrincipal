package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.aplicacion.dto.PerfilDTO;
import co.edu.uco.arquisw.aplicacion.dto.RolDTO;
import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioConsultarUsuarios;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServicioAplicacionConsultarUsuarios
{
    private final ServicioConsultarUsuarios servicioConsultarUsuarios;

    public ServicioAplicacionConsultarUsuarios(ServicioConsultarUsuarios servicioConsultarUsuarios)
    {
        this.servicioConsultarUsuarios = servicioConsultarUsuarios;
    }

    public List<UsuarioDTO> consultar()
    {
        return ensamblarUsuarios(this.servicioConsultarUsuarios.consultar());
    }

    private UsuarioDTO ensamblar(Usuario usuario)
    {
        return new UsuarioDTO(usuario.getCodigo(), usuario.getNombre(), usuario.getApellidos(), usuario.getNumeroIdentificacion(), usuario.getCorreo(), usuario.getClave(), usuario.getInstitucion(), new PerfilDTO(usuario.getPerfil().getCodigo(), usuario.getPerfil().getNombre()));
    }

    private List<UsuarioDTO> ensamblarUsuarios(List<Usuario> usuarios)
    {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for(Usuario usuario : usuarios)
        {
            usuariosDTO.add(ensamblar(usuario));
        }

        return usuariosDTO;
    }
}