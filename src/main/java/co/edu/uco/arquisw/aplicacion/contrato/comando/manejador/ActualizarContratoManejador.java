package co.edu.uco.arquisw.aplicacion.contrato.comando.manejador;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;
import co.edu.uco.arquisw.aplicacion.contrato.comando.fabrica.ContratoFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioActualizarContrato;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActualizarContratoManejador implements ManejadorComandoVariableDeRutaRespuesta<ContratoComando, Long, ComandoRespuesta<Long>> {
    private final ServicioActualizarContrato servicioActualizarContrato;
    private final ContratoFabrica contratoFabrica;

    @Override
    public ComandoRespuesta<Long> ejecutar(ContratoComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioActualizarContrato.ejecutar(this.contratoFabrica.construir(comando), id));
    }
}