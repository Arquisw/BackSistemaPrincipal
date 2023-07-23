package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.ValidarCodigoRecuperacionClaveComando;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioValidarCodigoRecuperacionClave;
import org.springframework.stereotype.Component;

@Component
public class ValidarCodigoRecuperacionClaveManejador implements ManejadorComandoActualizacionRespuesta<ValidarCodigoRecuperacionClaveComando, String, ComandoRespuesta<Boolean>> {
    private final ServicioValidarCodigoRecuperacionClave servicioValidarCodigoRecuperacionClave;

    public ValidarCodigoRecuperacionClaveManejador(ServicioValidarCodigoRecuperacionClave servicioValidarCodigoRecuperacionClave) {
        this.servicioValidarCodigoRecuperacionClave = servicioValidarCodigoRecuperacionClave;
    }

    @Override
    public ComandoRespuesta<Boolean> ejecutar(ValidarCodigoRecuperacionClaveComando comando, String correo) {
        return new ComandoRespuesta<>(this.servicioValidarCodigoRecuperacionClave.ejecutar(correo, comando.getCodigo()));
    }
}
