package co.edu.uco.arquisw.infraestructura.postulacion.controlador;

import co.edu.uco.arquisw.aplicacion.postulacion.consulta.*;
import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/postulaciones")
@Tag(name = "Consulta del Usuario Controlador")
public class PostulacionConsultaControlador {
    private final ConsultarPostulacionPorIdManejador consultarPostulacionPorIdManejador;
    private final ConsultarPostulacionesPorProyectoManejador consultarPostulacionesPorProyectoManejador;
    private final ConsultarSeleccionPorIdManejador consultarSeleccionPorIdManejador;
    private final ConsultarSeleccionesPorProyectoManejador consultarSeleccionesPorProyectoManejador;
    private final ConsultarPostulacionesPorUsuarioIdManejador consultarPostulacionesPorUsuarioIdManejador;
    private final ConsultarSeleccionesPorUsuarioIdManejador consultarSeleccionesPorUsuarioIdManejador;

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping("/postulacion/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una postulacion por medio de su ID")
    public PostulacionDTO consultarPostulacionPorId(@PathVariable Long id) {
        return this.consultarPostulacionPorIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/postulacion/usuario/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar todas las postulaciones de un usuario por medio de su ID")
    public List<PostulacionDTO> consultarPostulacionesPorUsuarioId(@PathVariable Long id) {
        return this.consultarPostulacionesPorUsuarioIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping("/proyecto/{id}")
    @Operation(summary = "Consultar Todos por ID del proyecto", description = "Este es usado para consultar todas las postulaciones que esten en espera de ser aprobadas.")
    public List<PostulacionDTO> consultarPostulacionesPorProyectoId(@PathVariable Long id) {
        return this.consultarPostulacionesPorProyectoManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/selecciones/seleccion/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una seleccion por medio de su ID")
    public SeleccionDTO consultarSeleccionPorId(@PathVariable Long id) {
        return this.consultarSeleccionPorIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/selecciones/seleccion/usuario/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar todas las selecciones de un usuario por medio de su ID")
    public List<SeleccionDTO> consultarSeleccionesPorUsuarioId(@PathVariable Long id) {
        return this.consultarSeleccionesPorUsuarioIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/selecciones/{id}")
    @Operation(summary = "Consultar Todos", description = "Este es usado para consultar todas los postulados que están aprobados en un proyecto")
    public List<SeleccionDTO> consultarSelecciones(@PathVariable Long id) {
        return this.consultarSeleccionesPorProyectoManejador.ejecutar(id);
    }
}