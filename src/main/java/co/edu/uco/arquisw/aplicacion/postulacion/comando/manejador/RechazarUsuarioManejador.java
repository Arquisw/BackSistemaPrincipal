package co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.MotivoRechazoPostulacionComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.fabrica.MotivoRechazoPostulacionFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioRechazarUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
@AllArgsConstructor
public class RechazarUsuarioManejador implements ManejadorComandoVariableDeRutaRespuesta<MotivoRechazoPostulacionComando, Long, ComandoRespuesta<Long>> {
    private final ServicioRechazarUsuario servicioRechazarUsuario;
    private final MotivoRechazoPostulacionFabrica motivoRechazoPostulacionFabrica;

    @Override
    public ComandoRespuesta<Long> ejecutar(MotivoRechazoPostulacionComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioRechazarUsuario.ejecutar(this.motivoRechazoPostulacionFabrica.construir(comando), id));
    }
}