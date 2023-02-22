package co.edu.uco.arquisw.infraestructura.asociacion.controlador;

import co.edu.uco.arquisw.aplicacion.asociacion.consulta.ConsultarAsociacionPorIdManejador;
import co.edu.uco.arquisw.aplicacion.asociacion.consulta.ConsultarPeticionesDeEliminacionAsociacionManejador;
import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.dto.PeticionEliminacionAsociacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/asociaciones")
@Tag(name = "Consulta de la Asociacion Controlador")
public class AsociacionConsultaControlador
{
    private final ConsultarAsociacionPorIdManejador consultarAsociacionPorIdManejador;
    private final ConsultarPeticionesDeEliminacionAsociacionManejador consultarPeticionesDeEliminacionAsociacionManejador;

    public AsociacionConsultaControlador(ConsultarAsociacionPorIdManejador consultarAsociacionPorIdManejador, ConsultarPeticionesDeEliminacionAsociacionManejador consultarPeticionesDeEliminacionAsociacionManejador)
    {
        this.consultarAsociacionPorIdManejador = consultarAsociacionPorIdManejador;
        this.consultarPeticionesDeEliminacionAsociacionManejador = consultarPeticionesDeEliminacionAsociacionManejador;
    }
    @PreAuthorize("hasRole('ROLE_ASOCIACION')")
    @GetMapping("/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una asociacion por medio del ID de un Usuario")
    public AsociacionDTO consultarPorId(@PathVariable Long id)
    {
        return this.consultarAsociacionPorIdManejador.ejecutar(id);
    }
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping("/administrador")
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todas las peticiones de eliminación de una asociacion")
    public List<PeticionEliminacionAsociacionDTO> consultarPeticionesDeEliminacion()
    {
        return this.consultarPeticionesDeEliminacionAsociacionManejador.ejecutar();
    }
}