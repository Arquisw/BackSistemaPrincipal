package co.edu.uco.arquisw.aplicacion.contrato.comando.manejador;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;
import co.edu.uco.arquisw.aplicacion.contrato.comando.fabrica.ContratoFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoContratoRespuesta;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioGuardarContrato;
import org.springframework.stereotype.Component;

@Component
public class GuardarContratoManejador implements ManejadorComandoContratoRespuesta<ContratoComando, Long, String, ComandoRespuesta<Long>> {
    private final ServicioGuardarContrato servicioGuardarContrato;
    private final ContratoFabrica contratoFabrica;

    public GuardarContratoManejador(ServicioGuardarContrato servicioGuardarContrato, ContratoFabrica contratoFabrica) {
        this.servicioGuardarContrato = servicioGuardarContrato;
        this.contratoFabrica = contratoFabrica;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ContratoComando comando, Long id, String token) {
        return new ComandoRespuesta<>(this.servicioGuardarContrato.ejecutar(this.contratoFabrica.construir(comando), id, token));
    }
}