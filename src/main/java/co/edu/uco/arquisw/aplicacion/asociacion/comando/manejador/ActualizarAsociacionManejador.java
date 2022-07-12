package co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.asociacion.comando.AsociacionComando;
import co.edu.uco.arquisw.aplicacion.asociacion.comando.fabrica.AsociacionFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioActualizarAsociacion;
import org.springframework.stereotype.Component;

@Component
public class ActualizarAsociacionManejador implements ManejadorComandoActualizacionRespuesta<AsociacionComando, Long, ComandoRespuesta<Long>>
{
    private final AsociacionFabrica asociacionFabrica;
    private final ServicioActualizarAsociacion servicioActualizarAsociacion;

    public ActualizarAsociacionManejador(AsociacionFabrica asociacionFabrica, ServicioActualizarAsociacion servicioActualizarAsociacion)
    {
        this.asociacionFabrica = asociacionFabrica;
        this.servicioActualizarAsociacion = servicioActualizarAsociacion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(AsociacionComando comando, Long id)
    {
        return new ComandoRespuesta<>(this.servicioActualizarAsociacion.ejecutar(this.asociacionFabrica.construir(comando), id));
    }
}