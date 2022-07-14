package co.edu.uco.arquisw.aplicacion.postulacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarPostulacionPorUsuarioId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarPostulacionPorUsuarioIdManejador implements ManejadorComandoRespuesta<Long, PostulacionDTO>
{
    private final ServicioConsultarPostulacionPorUsuarioId servicioConsultarPostulacionPorUsuarioId;

    public ConsultarPostulacionPorUsuarioIdManejador(ServicioConsultarPostulacionPorUsuarioId servicioConsultarPostulacionPorUsuarioId)
    {
        this.servicioConsultarPostulacionPorUsuarioId = servicioConsultarPostulacionPorUsuarioId;
    }

    @Override
    public PostulacionDTO ejecutar(Long comando)
    {
        return this.servicioConsultarPostulacionPorUsuarioId.ejecutar(comando);
    }
}