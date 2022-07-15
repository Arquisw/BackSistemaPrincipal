package co.edu.uco.arquisw.infraestructura.postulacion.controlador;

import co.edu.uco.arquisw.aplicacion.postulacion.consulta.*;
import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/postulaciones")
@Tag(name = "Consulta del Usuario Controlador")
public class PostulacionConsultaControlador
{
    private final ConsultarPostulacionPorIdManejador consultarPostulacionPorIdManejador;
    private final ConsultarPostulacionesPorProyectoManejador consultarPostulacionesPorProyectoManejador;
    private final ConsultarSeleccionPorIdManejador consultarSeleccionPorIdManejador;
    private final ConsultarSeleccionesPorProyectoManejador consultarSeleccionesPorProyectoManejador;
    private final ConsultarPostulacionPorUsuarioIdManejador consultarPostulacionPorUsuarioIdManejador;
    private final ConsultarSeleccionPorUsuarioIdManejador consultarSeleccionPorUsuarioIdManejador;

    public PostulacionConsultaControlador(ConsultarPostulacionPorIdManejador consultarPostulacionPorIdManejador, ConsultarPostulacionesPorProyectoManejador consultarPostulacionesPorProyectoManejador, ConsultarSeleccionPorIdManejador consultarSeleccionPorIdManejador, ConsultarSeleccionesPorProyectoManejador consultarSeleccionesPorProyectoManejador, ConsultarPostulacionPorUsuarioIdManejador consultarPostulacionPorUsuarioIdManejador, ConsultarSeleccionPorUsuarioIdManejador consultarSeleccionPorUsuarioIdManejador)
    {
        this.consultarPostulacionPorIdManejador = consultarPostulacionPorIdManejador;
        this.consultarPostulacionesPorProyectoManejador = consultarPostulacionesPorProyectoManejador;
        this.consultarSeleccionPorIdManejador = consultarSeleccionPorIdManejador;
        this.consultarSeleccionesPorProyectoManejador = consultarSeleccionesPorProyectoManejador;
        this.consultarPostulacionPorUsuarioIdManejador = consultarPostulacionPorUsuarioIdManejador;
        this.consultarSeleccionPorUsuarioIdManejador = consultarSeleccionPorUsuarioIdManejador;
    }

    @GetMapping("/postulacion/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una postulacion por medio de su ID")
    public PostulacionDTO consultarPostulacionPorId(@PathVariable Long id)
    {
        return this.consultarPostulacionPorIdManejador.ejecutar(id);
    }

    @GetMapping("/postulacion/usuario/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una postulacion por medio del ID del usuario")
    public PostulacionDTO consultarPostulacionPorUsuarioId(@PathVariable Long id)
    {
        return this.consultarPostulacionPorUsuarioIdManejador.ejecutar(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar Todos por ID del proyecto", description = "Este es usado para consultar todas las postulaciones que esten en espera de ser aprobadas.")
    public List<PostulacionDTO> consultarPostulaciones(@PathVariable Long id)
    {
        return this.consultarPostulacionesPorProyectoManejador.ejecutar(id);
    }

    @GetMapping("/selecciones/seleccion/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una seleccion por medio de su ID")
    public SeleccionDTO consultarSeleccionPorId(@PathVariable Long id)
    {
        return this.consultarSeleccionPorIdManejador.ejecutar(id);
    }

    @GetMapping("/selecciones/seleccion/usuario/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una seleccion por medio del ID de un Usuario")
    public SeleccionDTO consultarSeleccionPorUsuarioId(@PathVariable Long id)
    {
        return this.consultarSeleccionPorUsuarioIdManejador.ejecutar(id);
    }

    @GetMapping("/selecciones/{id}")
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todas los postulados que están aprobados en un proyecto")
    public List<SeleccionDTO> consultarSelecciones(@PathVariable Long id)
    {
        return this.consultarSeleccionesPorProyectoManejador.ejecutar(id);
    }
}