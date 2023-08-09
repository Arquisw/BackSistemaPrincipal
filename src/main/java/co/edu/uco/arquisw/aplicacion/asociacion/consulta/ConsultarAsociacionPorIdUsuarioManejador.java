package co.edu.uco.arquisw.aplicacion.asociacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioConsultarAsociacionPorIDUsuario;
import org.springframework.stereotype.Component;

@Component
public class ConsultarAsociacionPorIdUsuarioManejador implements ManejadorComandoRespuesta<Long, AsociacionDTO> {
    private final ServicioConsultarAsociacionPorIDUsuario servicioConsultarAsociacionPorIDUsuario;

    public ConsultarAsociacionPorIdUsuarioManejador(ServicioConsultarAsociacionPorIDUsuario servicioConsultarAsociacionPorIDUsuario) {
        this.servicioConsultarAsociacionPorIDUsuario = servicioConsultarAsociacionPorIDUsuario;
    }

    @Override
    public AsociacionDTO ejecutar(Long comando) {
        return this.servicioConsultarAsociacionPorIDUsuario.ejecutar(comando);
    }
}