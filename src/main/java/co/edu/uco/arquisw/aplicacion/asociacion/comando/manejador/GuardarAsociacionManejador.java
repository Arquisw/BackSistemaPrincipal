package co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.asociacion.comando.AsociacionComando;
import co.edu.uco.arquisw.aplicacion.asociacion.comando.fabrica.AsociacionFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioGuardarAsociacion;
import org.springframework.stereotype.Component;

@Component
public class GuardarAsociacionManejador implements ManejadorComandoVariableDeRutaRespuesta<AsociacionComando, Long, ComandoRespuesta<Long>> {
    private final AsociacionFabrica asociacionFabrica;
    private final ServicioGuardarAsociacion servicioGuardarAsociacion;

    public GuardarAsociacionManejador(AsociacionFabrica asociacionFabrica, ServicioGuardarAsociacion servicioGuardarAsociacion) {
        this.asociacionFabrica = asociacionFabrica;
        this.servicioGuardarAsociacion = servicioGuardarAsociacion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(AsociacionComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioGuardarAsociacion.ejecutar(this.asociacionFabrica.construir(comando), id));
    }
}