package co.edu.uco.arquisw.infraestructura.contrato.controlador;

import co.edu.uco.arquisw.aplicacion.contrato.consulta.ConsultarContratoPorIdManejador;
import co.edu.uco.arquisw.dominio.contrato.dto.ContratoDTO;
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
@RequestMapping("/contratos")
@Tag(name = "Consulta del Contrato Controlador")
public class ContratoConsultaControlador {
    private final ConsultarContratoPorIdManejador consultarContratoPorIdManejador;

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar un contrato por medio del ID de una necesidad")
    public ContratoDTO consultarPorId(@PathVariable Long id) {
        return this.consultarContratoPorIdManejador.ejecutar(id);
    }
}