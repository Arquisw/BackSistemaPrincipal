package co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioEliminarAsociacion;
import org.springframework.stereotype.Component;

@Component
public class EliminarAsociacionManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>>
{
    private final ServicioEliminarAsociacion servicioEliminarAsociacion;

    public EliminarAsociacionManejador(ServicioEliminarAsociacion servicioEliminarAsociacion)
    {
        this.servicioEliminarAsociacion = servicioEliminarAsociacion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando)
    {
        return new ComandoRespuesta<>(this.servicioEliminarAsociacion.ejecutar(comando));
    }
}