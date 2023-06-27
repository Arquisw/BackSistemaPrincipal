package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioAprobarProyectoPorRolLiderDeEquipo;
import org.springframework.stereotype.Component;

@Component
public class AprobarProyectoPorRolLiderDeEquipoManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioAprobarProyectoPorRolLiderDeEquipo servicioAprobarProyectoPorRolLiderDeEquipo;

    public AprobarProyectoPorRolLiderDeEquipoManejador(ServicioAprobarProyectoPorRolLiderDeEquipo servicioAprobarProyectoPorRolLiderDeEquipo) {
        this.servicioAprobarProyectoPorRolLiderDeEquipo = servicioAprobarProyectoPorRolLiderDeEquipo;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) {
        return new ComandoRespuesta<>(this.servicioAprobarProyectoPorRolLiderDeEquipo.ejecutar(comando));
    }
}