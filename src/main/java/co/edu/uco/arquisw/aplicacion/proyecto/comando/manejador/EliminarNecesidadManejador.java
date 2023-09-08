package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioEliminarNecesidad;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class EliminarNecesidadManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioEliminarNecesidad servicioEliminarNecesidad;

    public EliminarNecesidadManejador(ServicioEliminarNecesidad servicioEliminarNecesidad) {
        this.servicioEliminarNecesidad = servicioEliminarNecesidad;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) throws MessagingException {
        return new ComandoRespuesta<>(this.servicioEliminarNecesidad.ejecutar(comando));
    }
}