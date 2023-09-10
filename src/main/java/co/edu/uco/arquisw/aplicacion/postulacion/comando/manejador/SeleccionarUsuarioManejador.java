package co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.SeleccionComando;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioSeleccionarUsuario;
import org.springframework.stereotype.Component;

@Component
public class SeleccionarUsuarioManejador implements ManejadorComandoVariableDeRutaRespuesta<SeleccionComando, Long, ComandoRespuesta<Long>> {
    private final ServicioSeleccionarUsuario servicioSeleccionarUsuario;

    public SeleccionarUsuarioManejador(ServicioSeleccionarUsuario servicioSeleccionarUsuario) {
        this.servicioSeleccionarUsuario = servicioSeleccionarUsuario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(SeleccionComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioSeleccionarUsuario.ejecutar(comando.getRoles(), id));
    }
}