package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.PropetarioProyectoComando;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioUsuarioEsPropetarioDelProyecto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEsPropetarioDelProyectoManejador implements ManejadorComandoRespuesta<PropetarioProyectoComando, ComandoRespuesta<Boolean>> {
    private final ServicioUsuarioEsPropetarioDelProyecto servicioUsuarioEsPropetarioDelProyecto;

    public UsuarioEsPropetarioDelProyectoManejador(ServicioUsuarioEsPropetarioDelProyecto servicioUsuarioEsPropetarioDelProyecto) {
        this.servicioUsuarioEsPropetarioDelProyecto = servicioUsuarioEsPropetarioDelProyecto;
    }

    @Override
    public ComandoRespuesta<Boolean> ejecutar(PropetarioProyectoComando comando) {
        return new ComandoRespuesta<>(this.servicioUsuarioEsPropetarioDelProyecto.ejecutar(comando.getNecesidadId(), comando.getUsuarioId()));
    }
}