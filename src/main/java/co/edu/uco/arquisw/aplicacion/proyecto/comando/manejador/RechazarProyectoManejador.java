package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.MotivoRechazoNecesidadComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica.MotivoRechazoNecesidadFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioRechazarProyecto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RechazarProyectoManejador implements ManejadorComandoVariableDeRutaRespuesta<MotivoRechazoNecesidadComando, Long, ComandoRespuesta<Long>> {
    private final MotivoRechazoNecesidadFabrica motivoRechazoNecesidadFabrica;
    private final ServicioRechazarProyecto servicioRechazarProyecto;

    @Override
    public ComandoRespuesta<Long> ejecutar(MotivoRechazoNecesidadComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioRechazarProyecto.ejecutar(this.motivoRechazoNecesidadFabrica.construir(comando), id));
    }
}