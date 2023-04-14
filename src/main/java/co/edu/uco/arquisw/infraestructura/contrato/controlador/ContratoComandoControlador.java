package co.edu.uco.arquisw.infraestructura.contrato.controlador;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;
import co.edu.uco.arquisw.aplicacion.contrato.comando.manejador.ActualizarContratoManejador;
import co.edu.uco.arquisw.aplicacion.contrato.comando.manejador.GuardarContratoManejador;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/contratos")
@Tag(name = "Comando del Contrato Controlador")
public class ContratoComandoControlador {
    private final GuardarContratoManejador guardarContratoManejador;
    private final ActualizarContratoManejador actualizarContratoManejador;

    public ContratoComandoControlador(GuardarContratoManejador guardarContratoManejador, ActualizarContratoManejador actualizarContratoManejador) {
        this.guardarContratoManejador = guardarContratoManejador;
        this.actualizarContratoManejador = actualizarContratoManejador;
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PostMapping("/{id}")
    @Operation(summary = "Guardar Contrato", description = "Este es usado para guardar un contrato en la aplicación por medio del ID de una necesidad")
    public ComandoRespuesta<Long> guardar(HttpServletRequest peticion, @RequestBody ContratoComando contrato, @PathVariable Long id) {
        String token = peticion.getHeader(TextoConstante.HEADER_VALUE);

        return this.guardarContratoManejador.ejecutar(contrato, id, token);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Asociacion", description = "Este es usado para actualizar los datos de un contrato por medio del ID de una necesidad")
    public ComandoRespuesta<Long> actualizar(@RequestBody ContratoComando contrato, @PathVariable Long id) {
        return this.actualizarContratoManejador.ejecutar(contrato, id);
    }
}