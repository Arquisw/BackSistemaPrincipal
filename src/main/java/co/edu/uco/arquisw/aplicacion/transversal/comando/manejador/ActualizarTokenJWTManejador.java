package co.edu.uco.arquisw.aplicacion.transversal.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.Manejador;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActualizarTokenJWTManejador implements Manejador {
    private final ServicioActualizarToken servicioActualizarToken;

    @Override
    public void ejecutar() {
        this.servicioActualizarToken.ejecutar();
    }
}