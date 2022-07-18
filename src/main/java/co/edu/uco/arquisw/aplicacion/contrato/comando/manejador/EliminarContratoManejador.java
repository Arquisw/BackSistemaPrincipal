package co.edu.uco.arquisw.aplicacion.contrato.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioEliminarContrato;
import org.springframework.stereotype.Component;

@Component
public class EliminarContratoManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>>
{
    private final ServicioEliminarContrato servicioEliminarContrato;

    public EliminarContratoManejador(ServicioEliminarContrato servicioEliminarContrato)
    {
        this.servicioEliminarContrato = servicioEliminarContrato;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando)
    {
        return new ComandoRespuesta<>(this.servicioEliminarContrato.ejecutar(comando));
    }
}