package co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioSeleccionarUsuario;
import org.springframework.stereotype.Component;

@Component
public class SeleccionarUsuarioManejador implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {
    private final ServicioSeleccionarUsuario servicioSeleccionarUsuario;

    public SeleccionarUsuarioManejador(ServicioSeleccionarUsuario servicioSeleccionarUsuario) {
        this.servicioSeleccionarUsuario = servicioSeleccionarUsuario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Long id) {
        return new ComandoRespuesta<>(this.servicioSeleccionarUsuario.ejecutar(id));
    }
}