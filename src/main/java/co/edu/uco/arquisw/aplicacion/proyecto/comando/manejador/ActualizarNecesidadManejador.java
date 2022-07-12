package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.NecesidadComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica.NecesidadFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioActualizarNecesidad;
import org.springframework.stereotype.Component;

@Component
public class ActualizarNecesidadManejador implements ManejadorComandoActualizacionRespuesta<NecesidadComando, Long, ComandoRespuesta<Long>>
{
    private final NecesidadFabrica necesidadFabrica;
    private final ServicioActualizarNecesidad servicioActualizarNecesidad;

    public ActualizarNecesidadManejador(NecesidadFabrica necesidadFabrica, ServicioActualizarNecesidad servicioActualizarNecesidad)
    {
        this.necesidadFabrica = necesidadFabrica;
        this.servicioActualizarNecesidad = servicioActualizarNecesidad;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(NecesidadComando comando, Long id)
    {
        return new ComandoRespuesta<>(this.servicioActualizarNecesidad.ejecutar(this.necesidadFabrica.construirActualizar(comando, id), id));
    }
}