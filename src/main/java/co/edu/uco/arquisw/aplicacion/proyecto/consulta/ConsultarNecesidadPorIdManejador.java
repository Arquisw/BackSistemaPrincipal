package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarNecesidadPorId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarNecesidadPorIdManejador implements ManejadorComandoRespuesta<Long, NecesidadDTO> {
    private final ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId;

    public ConsultarNecesidadPorIdManejador(ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId) {
        this.servicioConsultarNecesidadPorId = servicioConsultarNecesidadPorId;
    }

    @Override
    public NecesidadDTO ejecutar(Long comando) {
        return this.servicioConsultarNecesidadPorId.ejecutar(comando);
    }
}
