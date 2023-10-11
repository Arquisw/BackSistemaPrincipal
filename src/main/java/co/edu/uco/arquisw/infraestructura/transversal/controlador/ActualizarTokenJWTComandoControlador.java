package co.edu.uco.arquisw.infraestructura.transversal.controlador;

import co.edu.uco.arquisw.aplicacion.transversal.comando.manejador.ActualizarTokenJWTManejador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/token")
@Tag(name = "Comando Actualizar Token JWT Controladorr")
public class ActualizarTokenJWTComandoControlador {
    private final ActualizarTokenJWTManejador actualizarTokenJWTManejador;

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/actualizar")
    @Operation(summary = "Actualizar Token", description = "Este es usado para actualizar el token en el header")
    public void consultarUsuarioPorCorreo(@PathVariable String correo) {
        this.actualizarTokenJWTManejador.ejecutar();
    }
}