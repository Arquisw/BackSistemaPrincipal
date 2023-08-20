package co.edu.uco.arquisw.infraestructura.proyecto.controlador;

import co.edu.uco.arquisw.aplicacion.proyecto.consulta.*;
import co.edu.uco.arquisw.dominio.proyecto.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
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

    public NecesidadConsultaControlador(ConsultarNecesidadesManejador consultarNecesidadesManejador, ConsultarNecesidadPorIdManejador consultarNecesidadPorIdManejador, ConsultarProyectoPorIdManejador consultarProyectoPorIdManejador, ConsultarProyectosAprobadosManejador consultarProyectosAprobadosManejador, ConsultarPeticionesDeEliminacionNecesidadManejador consultarPeticionesDeEliminacionNecesidadManejador, ConsultarNecesidadesPorAsociacionIdManejador consultarNecesidadesPorAsociacionIdManejador, ConsultarNecesidadPorProyectoIdManejador consultarNecesidadPorProyectoIdManejador, ConsultarRequerimientosPorNecesidadIdManejador consultarRequerimientosPorNecesidadIdManejador, ConsultarProyectosNegociadosManejador consultarProyectosNegociadosManejador) {
        this.consultarNecesidadesManejador = consultarNecesidadesManejador;
        this.consultarNecesidadPorIdManejador = consultarNecesidadPorIdManejador;
        this.consultarProyectoPorIdManejador = consultarProyectoPorIdManejador;
        this.consultarProyectosAprobadosManejador = consultarProyectosAprobadosManejador;
        this.consultarPeticionesDeEliminacionNecesidadManejador = consultarPeticionesDeEliminacionNecesidadManejador;
        this.consultarNecesidadesPorAsociacionIdManejador = consultarNecesidadesPorAsociacionIdManejador;
        this.consultarNecesidadPorProyectoIdManejador = consultarNecesidadPorProyectoIdManejador;
        this.consultarRequerimientosPorNecesidadIdManejador = consultarRequerimientosPorNecesidadIdManejador;
        this.consultarProyectosNegociadosManejador = consultarProyectosNegociadosManejador;
    }

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
    public List<NecesidadDTO> consultar() {
        return this.consultarNecesidadesManejador.ejecutar();
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
    public List<NecesidadDTO> consultarProyectosAprobados() {
        return this.consultarProyectosAprobadosManejador.ejecutar();
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
    public List<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacion() {
        return this.consultarPeticionesDeEliminacionNecesidadManejador.ejecutar();
    }
}