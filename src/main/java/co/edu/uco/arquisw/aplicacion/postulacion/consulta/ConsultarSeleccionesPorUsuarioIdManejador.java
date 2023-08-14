package co.edu.uco.arquisw.aplicacion.postulacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarSeleccionesPorUsuarioId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultarSeleccionesPorUsuarioIdManejador implements ManejadorComandoRespuesta<Long, List<SeleccionDTO>> {
    private final ServicioConsultarSeleccionesPorUsuarioId servicioConsultarSeleccionesPorUsuarioId;

    public ConsultarSeleccionesPorUsuarioIdManejador(ServicioConsultarSeleccionesPorUsuarioId servicioConsultarSeleccionesPorUsuarioId) {
        this.servicioConsultarSeleccionesPorUsuarioId = servicioConsultarSeleccionesPorUsuarioId;
    }

    @Override
    public List<SeleccionDTO> ejecutar(Long comando) {
        return this.servicioConsultarSeleccionesPorUsuarioId.ejecutar(comando);
    }
}