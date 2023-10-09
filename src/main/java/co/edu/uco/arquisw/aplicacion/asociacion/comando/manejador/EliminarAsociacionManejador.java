package co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioEliminarAsociacion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EliminarAsociacionManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioEliminarAsociacion servicioEliminarAsociacion;

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) {
        return new ComandoRespuesta<>(this.servicioEliminarAsociacion.ejecutar(comando));
    }
}