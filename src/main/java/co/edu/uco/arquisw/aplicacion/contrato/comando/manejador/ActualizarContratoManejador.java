package co.edu.uco.arquisw.aplicacion.contrato.comando.manejador;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;
import co.edu.uco.arquisw.aplicacion.contrato.comando.fabrica.ContratoFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioActualizarContrato;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class ActualizarContratoManejador implements ManejadorComandoActualizacionRespuesta<ContratoComando, Long, ComandoRespuesta<Long>> {
    private final ServicioActualizarContrato servicioActualizarContrato;
    private final ContratoFabrica contratoFabrica;

    public ActualizarContratoManejador(ServicioActualizarContrato servicioActualizarContrato, ContratoFabrica contratoFabrica) {
        this.servicioActualizarContrato = servicioActualizarContrato;
        this.contratoFabrica = contratoFabrica;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ContratoComando comando, Long id) throws MessagingException {
        return new ComandoRespuesta<>(this.servicioActualizarContrato.ejecutar(this.contratoFabrica.construir(comando), id));
    }
}