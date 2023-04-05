package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioLogin;
import org.springframework.stereotype.Component;

@Component
public class LoginManejador implements ManejadorComandoRespuesta<String, ComandoRespuesta<Long>> {
    private final ServicioLogin servicioLogin;

    public LoginManejador(ServicioLogin servicioLogin) {
        this.servicioLogin = servicioLogin;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(String comando) {
        return new ComandoRespuesta<>(this.servicioLogin.ejecutar(comando));
    }
}