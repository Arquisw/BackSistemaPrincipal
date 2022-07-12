package co.edu.uco.arquisw.aplicacion.usuario.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioConsultarPersonaPorId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarPersonaPorIdManejador implements ManejadorComandoRespuesta<Long, PersonaDTO>
{
    private final ServicioConsultarPersonaPorId servicioConsultarPersonaPorId;

    public ConsultarPersonaPorIdManejador(ServicioConsultarPersonaPorId servicioConsultarPersonaPorId)
    {
        this.servicioConsultarPersonaPorId = servicioConsultarPersonaPorId;
    }

    @Override
    public PersonaDTO ejecutar(Long comando)
    {
        return this.servicioConsultarPersonaPorId.ejecutar(comando);
    }
}