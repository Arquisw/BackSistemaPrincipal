package co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioEliminarAsociacionPorAdministrador;
import org.springframework.stereotype.Component;

@Component
public class EliminarAsociacionPorAdministradorManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioEliminarAsociacionPorAdministrador servicioEliminarAsociacionPorAdministrador;

    public EliminarAsociacionPorAdministradorManejador(ServicioEliminarAsociacionPorAdministrador servicioEliminarAsociacionPorAdministrador) {
        this.servicioEliminarAsociacionPorAdministrador = servicioEliminarAsociacionPorAdministrador;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) {
        return new ComandoRespuesta<>(this.servicioEliminarAsociacionPorAdministrador.ejecutar(comando));
    }
}