package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioAprobarProyectoPorRolIngenieria;
import org.springframework.stereotype.Component;

@Component
public class AprobarProyectoPorRolIngenieriaManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioAprobarProyectoPorRolIngenieria servicioAprobarProyectoPorRolIngenieria;

    public AprobarProyectoPorRolIngenieriaManejador(ServicioAprobarProyectoPorRolIngenieria servicioAprobarProyectoPorRolIngenieria) {
        this.servicioAprobarProyectoPorRolIngenieria = servicioAprobarProyectoPorRolIngenieria;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando) {
        return new ComandoRespuesta<>(this.servicioAprobarProyectoPorRolIngenieria.ejecutar(comando));
    }
}