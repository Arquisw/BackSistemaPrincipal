package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.RolActualizacionComando;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioActualizarRolPorAdministrador;
import org.springframework.stereotype.Component;

@Component
public class ActualizarRolPorAdministradorManejador implements ManejadorComandoActualizacionRespuesta<RolActualizacionComando, Long, ComandoRespuesta<Long>> {
    private final ServicioActualizarRolPorAdministrador servicioActualizarRolPorAdministrador;

    public ActualizarRolPorAdministradorManejador(ServicioActualizarRolPorAdministrador servicioActualizarRolPorAdministrador) {
        this.servicioActualizarRolPorAdministrador = servicioActualizarRolPorAdministrador;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(RolActualizacionComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioActualizarRolPorAdministrador.ejecutar(comando.isLeer(), comando.isEscribir(), comando.isActualizar(), comando.isEliminar(), id));
    }
}