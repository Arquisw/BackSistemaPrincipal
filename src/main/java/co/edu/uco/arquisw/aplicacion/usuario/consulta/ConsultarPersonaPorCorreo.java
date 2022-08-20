package co.edu.uco.arquisw.aplicacion.usuario.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioConsultarPersonaPorCorreo;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioConsultarPersonaPorId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarPersonaPorCorreo implements ManejadorComandoRespuesta<String, PersonaDTO>
{
    private final ServicioConsultarPersonaPorCorreo servicioConsultarPersonaPorCorreo;

    public ConsultarPersonaPorCorreo(ServicioConsultarPersonaPorCorreo servicioConsultarPersonaPorCorreo)
    {
        this.servicioConsultarPersonaPorCorreo = servicioConsultarPersonaPorCorreo;
    }

    @Override
    public PersonaDTO ejecutar(String correo)
    {
        return this.servicioConsultarPersonaPorCorreo.ejecutar(correo);
    }
}