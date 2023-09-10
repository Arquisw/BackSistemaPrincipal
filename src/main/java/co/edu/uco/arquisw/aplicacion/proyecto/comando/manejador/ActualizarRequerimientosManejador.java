package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.RequerimientosComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica.RequerimientosFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioActualizarRequerimientos;
import org.springframework.stereotype.Component;

@Component
public class ActualizarRequerimientosManejador implements ManejadorComandoVariableDeRutaRespuesta<RequerimientosComando, Long, ComandoRespuesta<Long>> {
    private final RequerimientosFabrica requerimientosFabrica;
    private final ServicioActualizarRequerimientos servicioActualizarRequerimientos;

    public ActualizarRequerimientosManejador(RequerimientosFabrica requerimientosFabrica, ServicioActualizarRequerimientos servicioActualizarRequerimientos) {
        this.requerimientosFabrica = requerimientosFabrica;
        this.servicioActualizarRequerimientos = servicioActualizarRequerimientos;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(RequerimientosComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioActualizarRequerimientos.ejecutar(this.requerimientosFabrica.construir(comando), id));
    }
}