package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioIniciarRecuperacionClave;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;

@Component
public class IniciarRecuperacionClaveManejador implements ManejadorComandoRespuesta<String, ComandoRespuesta<Long>> {
    private final ServicioIniciarRecuperacionClave servicioIniciarRecuperacionClave;

    public IniciarRecuperacionClaveManejador(ServicioIniciarRecuperacionClave servicioIniciarRecuperacionClave) {
        this.servicioIniciarRecuperacionClave = servicioIniciarRecuperacionClave;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(String comando) throws MessagingException {
        return new ComandoRespuesta<>(this.servicioIniciarRecuperacionClave.ejecutar(comando));
    }
}