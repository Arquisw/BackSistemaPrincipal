package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.dto.AprobacionProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarAprobacionProyectoPorId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarAprobacionProyectoPorIdManejador implements ManejadorComandoRespuesta<Long, AprobacionProyectoDTO> {
    private final ServicioConsultarAprobacionProyectoPorId servicioConsultarAprobacionProyectoPorId;

    public ConsultarAprobacionProyectoPorIdManejador(ServicioConsultarAprobacionProyectoPorId servicioConsultarAprobacionProyectoPorId) {
        this.servicioConsultarAprobacionProyectoPorId = servicioConsultarAprobacionProyectoPorId;
    }

    @Override
    public AprobacionProyectoDTO ejecutar(Long comando) {
        return this.servicioConsultarAprobacionProyectoPorId.ejecutar(comando);
    }
}