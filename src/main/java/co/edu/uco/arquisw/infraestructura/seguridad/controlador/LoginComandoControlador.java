package co.edu.uco.arquisw.infraestructura.seguridad.controlador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.manejador.LoginManejador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Tag(name = "Controlador para el login")
public class LoginComandoControlador {
    private final LoginManejador loginManejador;

    public LoginComandoControlador(LoginManejador loginManejador) {
        this.loginManejador = loginManejador;
    }

    @RequestMapping("/login")
    @Operation(summary = "login", description = "Este es usado para confirmar el logeo exitoso de la cuenta")
    public ComandoRespuesta<Long> obtenerUsuarioTrasLogin(Principal usuario) {
        return this.loginManejador.ejecutar(usuario.getName());
    }
}