package co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.RequerimientosComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica.RequerimientosFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioGuardarRequerimientos;
import org.springframework.stereotype.Component;

@Component
public class GuardarRequerimientosManejador implements ManejadorComandoVariableDeRutaRespuesta<RequerimientosComando, Long, ComandoRespuesta<Long>> {
    private final RequerimientosFabrica requerimientosFabrica;
    private final ServicioGuardarRequerimientos servicioGuardarRequerimientos;

    public GuardarRequerimientosManejador(RequerimientosFabrica requerimientosFabrica, ServicioGuardarRequerimientos servicioGuardarRequerimientos) {
        this.requerimientosFabrica = requerimientosFabrica;
        this.servicioGuardarRequerimientos = servicioGuardarRequerimientos;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(RequerimientosComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioGuardarRequerimientos.ejecutar(this.requerimientosFabrica.construir(comando), id));
    }
}