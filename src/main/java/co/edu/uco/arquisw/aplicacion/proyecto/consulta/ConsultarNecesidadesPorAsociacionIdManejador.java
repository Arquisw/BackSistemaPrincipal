package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarNecesidadesPorAsociacionId;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultarNecesidadesPorAsociacionIdManejador {
    private final ServicioConsultarNecesidadesPorAsociacionId servicioConsultarNecesidadesPorAsociacionId;

    public ConsultarNecesidadesPorAsociacionIdManejador(ServicioConsultarNecesidadesPorAsociacionId servicioConsultarNecesidadesPorAsociacionId) {
        this.servicioConsultarNecesidadesPorAsociacionId = servicioConsultarNecesidadesPorAsociacionId;
    }

    @Transactional
    public List<NecesidadDTO> ejecutar(Long id) {
        return this.servicioConsultarNecesidadesPorAsociacionId.ejecutar(id);
    }
}