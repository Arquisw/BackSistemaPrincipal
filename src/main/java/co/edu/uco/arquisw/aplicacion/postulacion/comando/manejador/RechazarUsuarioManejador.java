package co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.RechazoComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.fabrica.RechazoFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioRechazarUsuario;
import org.springframework.stereotype.Component;

@Component
public class RechazarUsuarioManejador implements ManejadorComandoActualizacionRespuesta<RechazoComando, Long, ComandoRespuesta<Long>> {
    private final ServicioRechazarUsuario servicioRechazarUsuario;
    private final RechazoFabrica rechazoFabrica;

    public RechazarUsuarioManejador(ServicioRechazarUsuario servicioRechazarUsuario, RechazoFabrica rechazoFabrica) {
        this.servicioRechazarUsuario = servicioRechazarUsuario;
        this.rechazoFabrica = rechazoFabrica;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(RechazoComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioRechazarUsuario.ejecutar(this.rechazoFabrica.construir(comando), id));
    }
}
