package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioAprobarProyectoPorRolDirectorDeProyecto;
import org.springframework.stereotype.Component;

@Component
public class AprobarProyectoPorRolDirectorDeProyectoManejador implements ManejadorComandoActualizacionRespuesta<Long, String, ComandoRespuesta<Long>> {
    private final ServicioAprobarProyectoPorRolDirectorDeProyecto servicioAprobarProyectoPorRolDirectorDeProyecto;

    public AprobarProyectoPorRolDirectorDeProyectoManejador(ServicioAprobarProyectoPorRolDirectorDeProyecto servicioAprobarProyectoPorRolDirectorDeProyecto) {
        this.servicioAprobarProyectoPorRolDirectorDeProyecto = servicioAprobarProyectoPorRolDirectorDeProyecto;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long comando, String token) {
        return new ComandoRespuesta<>(this.servicioAprobarProyectoPorRolDirectorDeProyecto.ejecutar(comando, token));
    }
}