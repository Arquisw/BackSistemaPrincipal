package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.UsuarioEnsambladorImplementacion.obtenerUsuarioEnsamblador;

@Component
public class ServicioAplicacionGuardarUsuario
{
    private final ServicioGuardarUsuario servicioGuardarUsuario;

    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario)
    {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
    }

    public void guardar(UsuarioDTO usuario)
    {
        this.servicioGuardarUsuario.guardar(obtenerUsuarioEnsamblador().ensamblarDominioDesdeDTO(usuario));
    }
}