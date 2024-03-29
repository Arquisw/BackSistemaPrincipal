package co.edu.uco.arquisw.infraestructura.proyecto.controlador;

import co.edu.uco.arquisw.aplicacion.proyecto.consulta.*;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.RequerimientosDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/necesidades")
@Tag(name = "Consulta de la Necesidad Controlador")
public class NecesidadConsultaControlador {
    private final ConsultarNecesidadesManejador consultarNecesidadesManejador;
    private final ConsultarNecesidadPorIdManejador consultarNecesidadPorIdManejador;
    private final ConsultarProyectoPorIdManejador consultarProyectoPorIdManejador;
    private final ConsultarProyectosAprobadosManejador consultarProyectosAprobadosManejador;
    private final ConsultarPeticionesDeEliminacionNecesidadManejador consultarPeticionesDeEliminacionNecesidadManejador;
    private final ConsultarNecesidadesPorAsociacionIdManejador consultarNecesidadesPorAsociacionIdManejador;
    private final ConsultarNecesidadPorProyectoIdManejador consultarNecesidadPorProyectoIdManejador;
    private final ConsultarRequerimientosPorNecesidadIdManejador consultarRequerimientosPorNecesidadIdManejador;
    private final ConsultarProyectosNegociadosManejador consultarProyectosNegociadosManejador;

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una necesidad por medio de su ID")
    public NecesidadDTO consultarPorId(@PathVariable Long id) {
        return this.consultarNecesidadPorIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("/proyecto/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una necesidad por medio del ID del proyecto")
    public NecesidadDTO consultarPorProyectoId(@PathVariable Long id) {
        return this.consultarNecesidadPorProyectoIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("/requerimientos/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una necesidad por medio del ID del proyecto")
    public RequerimientosDTO consultarRequerimientosPorNecesidadId(@PathVariable Long id) {
        return this.consultarRequerimientosPorNecesidadIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ASOCIACION')")
    @GetMapping("/asociacion/{id}")
    @Operation(summary = "Consultar Necesidades por ID", description = "Este es usado para consultar las necesidades de una asociación por medio de su ID")
    public List<NecesidadDTO> consultarNecesidadesPorId(@PathVariable Long id) {
        return this.consultarNecesidadesPorAsociacionIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todas las necesidades que esten en espera de ser aprobadas.")
    public Page<NecesidadDTO> consultar(@RequestParam(defaultValue = "0") int pagina,
                                        @RequestParam(defaultValue = "10") int tamano) {
        return this.consultarNecesidadesManejador.ejecutar(pagina, tamano);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/proyectos/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar un proyecto por medio del ID de un proyecto")
    public ProyectoDTO consultarProyectoPorId(@PathVariable Long id) {
        return this.consultarProyectoPorIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/proyectos")
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todos los proyectos aprobados")
    public Page<NecesidadDTO> consultarProyectosAprobados(@RequestParam(defaultValue = "0") int pagina,
                                                          @RequestParam(defaultValue = "10") int tamano) {
        return this.consultarProyectosAprobadosManejador.ejecutar(pagina, tamano);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/proyectos/negociados")
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todos los proyectos negociados y que aun no estan en desarrollo el proyecto")
    public List<NecesidadDTO> consultarProyectosNegociados() {
        return this.consultarProyectosNegociadosManejador.ejecutar();
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping("/administrador")
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todas las peticiones de eliminación de una necesidad")
    public Page<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacion(@RequestParam(defaultValue = "0") int pagina,
                                                                                  @RequestParam(defaultValue = "10") int tamano) {
        return this.consultarPeticionesDeEliminacionNecesidadManejador.ejecutar(pagina, tamano);
    }
}