package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioIniciarActivacionCuenta;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class IniciarActivacionCuentaManejador implements ManejadorComandoRespuesta<String, ComandoRespuesta<Long>> {
    private final ServicioIniciarActivacionCuenta servicioIniciarActivacionCuenta;

    public IniciarActivacionCuentaManejador(ServicioIniciarActivacionCuenta servicioIniciarActivacionCuenta) {
        this.servicioIniciarActivacionCuenta = servicioIniciarActivacionCuenta;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(String comando) throws MessagingException {
        return new ComandoRespuesta<>(this.servicioIniciarActivacionCuenta.ejecutar(comando));
    }
}