package co.edu.uco.arquisw.aplicacion.postulacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarSeleccinadoPorId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarSeleccionPorIdManejador implements ManejadorComandoRespuesta<Long, SeleccionDTO> {
    private final ServicioConsultarSeleccinadoPorId servicioConsultarSeleccinadoPorId;

    public ConsultarSeleccionPorIdManejador(ServicioConsultarSeleccinadoPorId servicioConsultarSeleccinadoPorId) {
        this.servicioConsultarSeleccinadoPorId = servicioConsultarSeleccinadoPorId;
    }

    @Override
    public SeleccionDTO ejecutar(Long comando) {
        return this.servicioConsultarSeleccinadoPorId.ejecutar(comando);
    }
}