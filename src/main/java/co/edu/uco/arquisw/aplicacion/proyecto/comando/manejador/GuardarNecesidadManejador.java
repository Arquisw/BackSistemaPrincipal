package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.ProyectoComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica.NecesidadFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioGuardarNecesidad;
import org.springframework.stereotype.Component;

@Component
public class GuardarNecesidadManejador implements ManejadorComandoActualizacionRespuesta<ProyectoComando, Long, ComandoRespuesta<Long>> {
    private final NecesidadFabrica necesidadFabrica;
    private final ServicioGuardarNecesidad servicioGuardarNecesidad;

    public GuardarNecesidadManejador(NecesidadFabrica necesidadFabrica, ServicioGuardarNecesidad servicioGuardarNecesidad) {
        this.necesidadFabrica = necesidadFabrica;
        this.servicioGuardarNecesidad = servicioGuardarNecesidad;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ProyectoComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioGuardarNecesidad.ejecutar(this.necesidadFabrica.construir(comando), id));
    }
}