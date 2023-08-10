package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.dto.RequerimientosDTO;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarRequerimientosPorNecesidadId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarRequerimientosPorNecesidadIdManejador implements ManejadorComandoRespuesta<Long, RequerimientosDTO> {
    private final ServicioConsultarRequerimientosPorNecesidadId servicioConsultarRequerimientosPorNecesidadId;

    public ConsultarRequerimientosPorNecesidadIdManejador(ServicioConsultarRequerimientosPorNecesidadId servicioConsultarRequerimientosPorNecesidadId) {
        this.servicioConsultarRequerimientosPorNecesidadId = servicioConsultarRequerimientosPorNecesidadId;
    }

    @Override
    public RequerimientosDTO ejecutar(Long comando) {
        return this.servicioConsultarRequerimientosPorNecesidadId.ejecutar(comando);
    }
}