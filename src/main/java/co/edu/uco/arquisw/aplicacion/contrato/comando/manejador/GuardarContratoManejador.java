package co.edu.uco.arquisw.aplicacion.contrato.comando.manejador;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;
import co.edu.uco.arquisw.aplicacion.contrato.comando.fabrica.ContratoFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioGuardarContrato;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
@AllArgsConstructor
public class GuardarContratoManejador implements ManejadorComandoVariableDeRutaRespuesta<ContratoComando, Long, ComandoRespuesta<Long>> {
    private final ServicioGuardarContrato servicioGuardarContrato;
    private final ContratoFabrica contratoFabrica;

    @Override
    public ComandoRespuesta<Long> ejecutar(ContratoComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioGuardarContrato.ejecutar(this.contratoFabrica.construir(comando), id));
    }
}