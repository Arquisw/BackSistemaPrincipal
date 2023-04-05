package co.edu.uco.arquisw.aplicacion.contrato.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.contrato.dto.ContratoDTO;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioConsultarContratoPorId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarContratoPorIdManejador implements ManejadorComandoRespuesta<Long, ContratoDTO> {
    private final ServicioConsultarContratoPorId servicioConsultarContratoPorId;

    public ConsultarContratoPorIdManejador(ServicioConsultarContratoPorId servicioConsultarContratoPorId) {
        this.servicioConsultarContratoPorId = servicioConsultarContratoPorId;
    }

    @Override
    public ContratoDTO ejecutar(Long comando) {
        return this.servicioConsultarContratoPorId.ejecutar(comando);
    }
}