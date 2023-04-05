package co.edu.uco.arquisw.aplicacion.postulacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarPostulacionPorId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarPostulacionPorIdManejador implements ManejadorComandoRespuesta<Long, PostulacionDTO> {
    private final ServicioConsultarPostulacionPorId servicioConsultarPostulacionPorId;

    public ConsultarPostulacionPorIdManejador(ServicioConsultarPostulacionPorId servicioConsultarPostulacionPorId) {
        this.servicioConsultarPostulacionPorId = servicioConsultarPostulacionPorId;
    }

    @Override
    public PostulacionDTO ejecutar(Long comando) {
        return this.servicioConsultarPostulacionPorId.ejecutar(comando);
    }
}