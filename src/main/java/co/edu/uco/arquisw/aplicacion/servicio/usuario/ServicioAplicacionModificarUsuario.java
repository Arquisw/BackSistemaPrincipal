package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioModificarUsuario;
import org.springframework.stereotype.Component;

import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.UsuarioEnsambladorImplementacion.obtenerUsuarioEnsamblador;

@Component
public class ServicioAplicacionModificarUsuario
{
    private final ServicioModificarUsuario servicioModificarUsuario;

    public ServicioAplicacionModificarUsuario(ServicioModificarUsuario servicioModificarUsuario)
    {
        this.servicioModificarUsuario = servicioModificarUsuario;
    }

    public void modificar(int codigo, UsuarioDTO usuario)
    {
        this.servicioModificarUsuario.modificar(codigo, obtenerUsuarioEnsamblador().ensamblarDominioDesdeDTO(usuario));
    }
}