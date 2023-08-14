package co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.MotivoRechazoPostulacionComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.fabrica.MotivoRechazoPostulacionFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioRechazarUsuario;
import org.springframework.stereotype.Component;

@Component
public class RechazarUsuarioManejador implements ManejadorComandoActualizacionRespuesta<MotivoRechazoPostulacionComando, Long, ComandoRespuesta<Long>> {
    private final ServicioRechazarUsuario servicioRechazarUsuario;
    private final MotivoRechazoPostulacionFabrica motivoRechazoPostulacionFabrica;

    public RechazarUsuarioManejador(ServicioRechazarUsuario servicioRechazarUsuario, MotivoRechazoPostulacionFabrica motivoRechazoPostulacionFabrica) {
        this.servicioRechazarUsuario = servicioRechazarUsuario;
        this.motivoRechazoPostulacionFabrica = motivoRechazoPostulacionFabrica;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(MotivoRechazoPostulacionComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioRechazarUsuario.ejecutar(this.motivoRechazoPostulacionFabrica.construir(comando), id));
    }
}
