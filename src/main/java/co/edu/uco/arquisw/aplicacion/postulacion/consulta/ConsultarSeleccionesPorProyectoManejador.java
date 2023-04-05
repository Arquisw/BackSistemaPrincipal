package co.edu.uco.arquisw.aplicacion.postulacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarSeleccionadoPorProyecto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ConsultarSeleccionesPorProyectoManejador implements ManejadorComandoRespuesta<Long, List<SeleccionDTO>> {
    private final ServicioConsultarSeleccionadoPorProyecto servicioConsultarSeleccionadoPorProyecto;

    public ConsultarSeleccionesPorProyectoManejador(ServicioConsultarSeleccionadoPorProyecto servicioConsultarSeleccionadoPorProyecto) {
        this.servicioConsultarSeleccionadoPorProyecto = servicioConsultarSeleccionadoPorProyecto;
    }

    @Override
    public List<SeleccionDTO> ejecutar(Long comando) {
        return this.servicioConsultarSeleccionadoPorProyecto.ejecutar(comando);
    }
}