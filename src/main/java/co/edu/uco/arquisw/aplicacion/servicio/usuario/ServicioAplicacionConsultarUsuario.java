package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
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

    public UsuarioResumenDTO consultarPorCodigo(int codigo)
    {
        return this.servicioConsultarUsuario.consultarPorCodigo(codigo);
    }
}
