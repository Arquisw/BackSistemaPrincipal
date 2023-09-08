package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioEliminarNecesidadPorAdministrador;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class EliminarNecesidadPorAdministradorManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioEliminarNecesidadPorAdministrador servicioEliminarNecesidadPorAdministrador;

    public EliminarNecesidadPorAdministradorManejador(ServicioEliminarNecesidadPorAdministrador servicioEliminarNecesidadPorAdministrador) {
        this.servicioEliminarNecesidadPorAdministrador = servicioEliminarNecesidadPorAdministrador;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) throws MessagingException {
        return new ComandoRespuesta<>(this.servicioEliminarNecesidadPorAdministrador.ejecutar(comando));
    }
}