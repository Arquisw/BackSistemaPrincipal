package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.RecuperarClaveComando;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioRecuperarClave;
import org.springframework.stereotype.Component;

@Component
public class RecuperarClaveManejador implements ManejadorComandoVariableDeRutaRespuesta<RecuperarClaveComando, String, ComandoRespuesta<Long>> {
    private final ServicioRecuperarClave servicioRecuperarClave;

    public RecuperarClaveManejador(ServicioRecuperarClave servicioRecuperarClave) {
        this.servicioRecuperarClave = servicioRecuperarClave;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(RecuperarClaveComando comando, String correo) {
        return new ComandoRespuesta<>(this.servicioRecuperarClave.ejecutar(correo, comando.getClave()));
    }
}