package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
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

    public UsuarioResumenDTO consultarPorCorreo(String correo)
    {
        return this.servicioConsultarUsuarioPorCorreo.consultarPorCorreo(correo);
    }
}
