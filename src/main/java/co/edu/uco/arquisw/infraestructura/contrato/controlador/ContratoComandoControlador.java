package co.edu.uco.arquisw.infraestructura.contrato.controlador;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;
import co.edu.uco.arquisw.aplicacion.contrato.comando.manejador.ActualizarContratoManejador;
import co.edu.uco.arquisw.aplicacion.contrato.comando.manejador.GuardarContratoManejador;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/contratos")
@Tag(name = "Comando del Contrato Controlador")
public class ContratoComandoControlador {
    private final GuardarContratoManejador guardarContratoManejador;
    private final ActualizarContratoManejador actualizarContratoManejador;

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PostMapping("/{id}")
    @Operation(summary = "Guardar Contrato", description = "Este es usado para guardar un contrato en la aplicación por medio del ID de una necesidad")
    public ComandoRespuesta<Long> guardar(@RequestBody ContratoComando contrato, @PathVariable Long id) {
        return this.guardarContratoManejador.ejecutar(contrato, id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Contrato", description = "Este es usado para actualizar los datos de un contrato por medio del ID de una necesidad")
    public ComandoRespuesta<Long> actualizar(@RequestBody ContratoComando contrato, @PathVariable Long id) {
        return this.actualizarContratoManejador.ejecutar(contrato, id);
    }
}