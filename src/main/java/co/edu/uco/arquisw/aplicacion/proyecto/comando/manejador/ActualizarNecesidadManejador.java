package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.ProyectoComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica.NecesidadFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioActualizarNecesidad;
import org.springframework.stereotype.Component;

@Component
public class ActualizarNecesidadManejador implements ManejadorComandoVariableDeRutaRespuesta<ProyectoComando, Long, ComandoRespuesta<Long>> {
    private final NecesidadFabrica necesidadFabrica;
    private final ServicioActualizarNecesidad servicioActualizarNecesidad;

    public ActualizarNecesidadManejador(NecesidadFabrica necesidadFabrica, ServicioActualizarNecesidad servicioActualizarNecesidad) {
        this.necesidadFabrica = necesidadFabrica;
        this.servicioActualizarNecesidad = servicioActualizarNecesidad;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ProyectoComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioActualizarNecesidad.ejecutar(this.necesidadFabrica.construirActualizar(comando, id), id));
    }
}