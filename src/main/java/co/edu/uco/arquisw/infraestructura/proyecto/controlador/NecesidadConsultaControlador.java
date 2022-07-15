package co.edu.uco.arquisw.infraestructura.proyecto.controlador;

import co.edu.uco.arquisw.aplicacion.proyecto.consulta.*;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/necesidades")
@Tag(name = "Consulta de la Necesidad Controlador")
public class NecesidadConsultaControlador
{
    private final ConsultarNecesidadesManejador consultarNecesidadesManejador;
    private final ConsultarNecesidadPorIdManejador consultarNecesidadPorIdManejador;
    private final ConsultarProyectoPorIdManejador consultarProyectoPorIdManejador;
    private final ConsultarProyectosManejador consultarProyectosManejador;
    private final ConsultarPeticionesDeEliminacionNecesidadManejador consultarPeticionesDeEliminacionNecesidadManejador;

    public NecesidadConsultaControlador(ConsultarNecesidadesManejador consultarNecesidadesManejador, ConsultarNecesidadPorIdManejador consultarNecesidadPorIdManejador, ConsultarProyectoPorIdManejador consultarProyectoPorIdManejador, ConsultarProyectosManejador consultarProyectosManejador, ConsultarPeticionesDeEliminacionNecesidadManejador consultarPeticionesDeEliminacionNecesidadManejador)
    {
        this.consultarNecesidadesManejador = consultarNecesidadesManejador;
        this.consultarNecesidadPorIdManejador = consultarNecesidadPorIdManejador;
        this.consultarProyectoPorIdManejador = consultarProyectoPorIdManejador;
        this.consultarProyectosManejador = consultarProyectosManejador;
        this.consultarPeticionesDeEliminacionNecesidadManejador = consultarPeticionesDeEliminacionNecesidadManejador;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una necesidad por medio del ID de una asociacion")
    public NecesidadDTO consultarPorId(@PathVariable Long id)
    {
        return this.consultarNecesidadPorIdManejador.ejecutar(id);
    }

    @GetMapping
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todas las necesidades que esten en espera de ser aprobadas.")
    public List<NecesidadDTO> consultar()
    {
        return this.consultarNecesidadesManejador.ejecutar();
    }

    @GetMapping("/proyectos/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar un proyecto por medio del ID de un proyecto")
    public ProyectoDTO consultarProyectoPorId(@PathVariable Long id)
    {
        return this.consultarProyectoPorIdManejador.ejecutar(id);
    }

    @GetMapping("/proyectos")
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todos los proyectos aprobados")
    public List<ProyectoDTO> consultarProyectos()
    {
        return this.consultarProyectosManejador.ejecutar();
    }

    @GetMapping("/administrador")
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todas las peticiones de eliminación de una necesidad")
    public List<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacion()
    {
        return this.consultarPeticionesDeEliminacionNecesidadManejador.ejecutar();
    }
}