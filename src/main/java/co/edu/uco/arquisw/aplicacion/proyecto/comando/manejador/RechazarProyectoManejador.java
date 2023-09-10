package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.MotivoRechazoNecesidadComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica.MotivoRechazoNecesidadFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioRechazarProyecto;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class RechazarProyectoManejador implements ManejadorComandoVariableDeRutaRespuesta<MotivoRechazoNecesidadComando, Long, ComandoRespuesta<Long>> {
    private final MotivoRechazoNecesidadFabrica motivoRechazoNecesidadFabrica;
    private final ServicioRechazarProyecto servicioRechazarProyecto;

    public RechazarProyectoManejador(MotivoRechazoNecesidadFabrica motivoRechazoNecesidadFabrica, ServicioRechazarProyecto servicioRechazarProyecto) {
        this.motivoRechazoNecesidadFabrica = motivoRechazoNecesidadFabrica;
        this.servicioRechazarProyecto = servicioRechazarProyecto;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(MotivoRechazoNecesidadComando comando, Long id) throws MessagingException {
        return new ComandoRespuesta<>(this.servicioRechazarProyecto.ejecutar(this.motivoRechazoNecesidadFabrica.construir(comando), id));
    }
}