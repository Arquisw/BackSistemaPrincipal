package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioAprobarProyecto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AprobarProyectoManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioAprobarProyecto servicioAprobarProyecto;

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) {
        return new ComandoRespuesta<>(this.servicioAprobarProyecto.ejecutar(comando));
    }
}