package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.ClaveActualizacionComando;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioActualizarClave;
import org.springframework.stereotype.Component;

@Component
public class ActualizarClaveManejador implements ManejadorComandoVariableDeRutaRespuesta<ClaveActualizacionComando, Long, ComandoRespuesta<Long>> {
    private final ServicioActualizarClave servicioActualizarClave;

    public ActualizarClaveManejador(ServicioActualizarClave servicioActualizarClave) {
        this.servicioActualizarClave = servicioActualizarClave;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ClaveActualizacionComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioActualizarClave.ejecutar(comando.getClaveAntigua(), comando.getClaveNueva(), id));
    }
}