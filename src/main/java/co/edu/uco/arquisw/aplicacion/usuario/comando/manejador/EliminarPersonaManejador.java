package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioEliminarPersona;
import org.springframework.stereotype.Component;

@Component
public class EliminarPersonaManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>>
{
    private final ServicioEliminarPersona servicioEliminarPersona;

    public EliminarPersonaManejador(ServicioEliminarPersona servicioEliminarPersona)
    {
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando)
    {
        return new ComandoRespuesta<>(this.servicioEliminarPersona.ejecutar(comando));
    }
}
