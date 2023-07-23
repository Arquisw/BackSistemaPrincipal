package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.RecuperarClaveComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica.UsuarioFabrica;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioRecuperarClave;
import org.springframework.stereotype.Component;

@Component
public class RecuperarClaveManejador implements ManejadorComandoActualizacionRespuesta<RecuperarClaveComando, String, ComandoRespuesta<Long>> {
    private final ServicioRecuperarClave servicioRecuperarClave;
    private final UsuarioFabrica usuarioFabrica;

    public RecuperarClaveManejador(ServicioRecuperarClave servicioRecuperarClave, UsuarioFabrica usuarioFabrica) {
        this.servicioRecuperarClave = servicioRecuperarClave;
        this.usuarioFabrica = usuarioFabrica;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(RecuperarClaveComando comando, String correo) {
        return new ComandoRespuesta<>(this.servicioRecuperarClave.ejecutar(usuarioFabrica.construir(correo, comando.getClave())));
    }
}