package co.edu.uco.arquisw.aplicacion.postulacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarPostulacionesPorUsuarioId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultarPostulacionesPorUsuarioIdManejador implements ManejadorComandoRespuesta<Long, List<PostulacionDTO>> {
    private final ServicioConsultarPostulacionesPorUsuarioId servicioConsultarPostulacionesPorUsuarioId;

    public ConsultarPostulacionesPorUsuarioIdManejador(ServicioConsultarPostulacionesPorUsuarioId servicioConsultarPostulacionesPorUsuarioId) {
        this.servicioConsultarPostulacionesPorUsuarioId = servicioConsultarPostulacionesPorUsuarioId;
    }

    @Override
    public List<PostulacionDTO> ejecutar(Long comando) {
        return this.servicioConsultarPostulacionesPorUsuarioId.ejecutar(comando);
    }
}