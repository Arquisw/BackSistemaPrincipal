package co.edu.uco.arquisw.aplicacion.asociacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioConsultarAsociacionPorID;
import org.springframework.stereotype.Component;

@Component
public class ConsultatAsociacionPorIdManejador implements ManejadorComandoRespuesta<Long, AsociacionDTO> {

    private ServicioConsultarAsociacionPorID servicioConsultarAsociacionPorID;

    public ConsultatAsociacionPorIdManejador(ServicioConsultarAsociacionPorID servicioConsultarAsociacionPorID) {
        this.servicioConsultarAsociacionPorID = servicioConsultarAsociacionPorID;
    }

    @Override
    public AsociacionDTO ejecutar(Long comando) {
        return this.servicioConsultarAsociacionPorID.ejecutar(comando);
    }
}