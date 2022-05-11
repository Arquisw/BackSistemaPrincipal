package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioConsultarUsuarios;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ServicioAplicacionConsultarUsuarios
{
    private final ServicioConsultarUsuarios servicioConsultarUsuarios;

    public ServicioAplicacionConsultarUsuarios(ServicioConsultarUsuarios servicioConsultarUsuarios)
    {
        this.servicioConsultarUsuarios = servicioConsultarUsuarios;
    }

    public List<UsuarioResumenDTO> consultar()
    {
        return this.servicioConsultarUsuarios.consultar();
    }
}