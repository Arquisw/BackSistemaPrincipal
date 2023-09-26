package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.ActivarCuentaComando;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioActivarCuenta;
import org.springframework.stereotype.Component;

@Component
public class ActivarCuentaManejador implements ManejadorComandoVariableDeRutaRespuesta<ActivarCuentaComando, String, ComandoRespuesta<Long>> {
    private final ServicioActivarCuenta servicioActivarCuenta;

    public ActivarCuentaManejador(ServicioActivarCuenta servicioActivarCuenta) {
        this.servicioActivarCuenta = servicioActivarCuenta;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ActivarCuentaComando comando, String correo) {
        return new ComandoRespuesta<>(this.servicioActivarCuenta.ejecutar(correo, comando.getCodigo()));
    }
}