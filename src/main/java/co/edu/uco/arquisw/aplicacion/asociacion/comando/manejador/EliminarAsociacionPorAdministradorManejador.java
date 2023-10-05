package co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioEliminarAsociacionPorAdministrador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
@AllArgsConstructor
public class EliminarAsociacionPorAdministradorManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioEliminarAsociacionPorAdministrador servicioEliminarAsociacionPorAdministrador;

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) {
        return new ComandoRespuesta<>(this.servicioEliminarAsociacionPorAdministrador.ejecutar(comando));
    }
}