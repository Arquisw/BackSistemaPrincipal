package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioConsultarUsuarioPorCorreoConClave;
import org.springframework.stereotype.Component;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.UsuarioEnsambladorImplementacion.obtenerUsuarioEnsamblador;

@Component
public class ServicioAplicacionConsultarUsuarioPorCorreoConClave
{
    private final ServicioConsultarUsuarioPorCorreoConClave servicioConsultarUsuarioPorCorreoConClave;

    public ServicioAplicacionConsultarUsuarioPorCorreoConClave(ServicioConsultarUsuarioPorCorreoConClave servicioConsultarUsuarioPorCorreoConClave)
    {
        this.servicioConsultarUsuarioPorCorreoConClave = servicioConsultarUsuarioPorCorreoConClave;
    }

    public UsuarioDTO consultarPorCorreoConClave(String correo)
    {
        return obtenerUsuarioEnsamblador().ensamblarDTODesdeDominio(this.servicioConsultarUsuarioPorCorreoConClave.consultarPorCorreoConClave(correo));
    }
}
