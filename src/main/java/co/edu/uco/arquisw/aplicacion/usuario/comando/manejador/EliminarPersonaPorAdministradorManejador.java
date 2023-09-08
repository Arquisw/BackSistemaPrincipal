package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioEliminarPersonaPorAdministrador;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class EliminarPersonaPorAdministradorManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioEliminarPersonaPorAdministrador servicioEliminarPersonaPorAdministrador;

    public EliminarPersonaPorAdministradorManejador(ServicioEliminarPersonaPorAdministrador servicioEliminarPersonaPorAdministrador) {
        this.servicioEliminarPersonaPorAdministrador = servicioEliminarPersonaPorAdministrador;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) throws MessagingException {
        return new ComandoRespuesta<>(this.servicioEliminarPersonaPorAdministrador.ejecutar(comando));
    }
}