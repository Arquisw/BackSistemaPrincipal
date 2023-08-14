package co.edu.uco.arquisw.infraestructura.proyecto.controlador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.MotivoRechazoNecesidadComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.ProyectoComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.RequerimientosComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador.*;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/necesidades")
@Tag(name = "Comando de la Necesidad Controlador")
public class NecesidadComandoControlador {
    private final GuardarNecesidadManejador guardarNecesidadManejador;
    private final ActualizarNecesidadManejador actualizarNecesidadManejador;
    private final EliminarNecesidadManejador eliminarNecesidadManejador;
    private final EliminarNecesidadPorAdministradorManejador eliminarNecesidadPorAdministradorManejador;
    private final AprobarProyectoManejador aprobarProyectoManejador;
    private final AprobarProyectoPorRolIngenieriaManejador aprobarProyectoPorRolIngenieriaManejador;
    private final AprobarProyectoPorRolLiderDeEquipoManejador aprobarProyectoPorRolLiderDeEquipoManejador;
    private final AprobarProyectoPorRolDirectorDeProyectoManejador aprobarProyectoPorRolDirectorDeProyectoManejador;
    private final GuardarRequerimientosManejador guardarRequerimientosManejador;
    private final ActualizarRequerimientosManejador actualizarRequerimientosManejador;
    private final RechazarProyectoManejador rechazarProyectoManejador;

    public NecesidadComandoControlador(GuardarNecesidadManejador guardarNecesidadManejador, ActualizarNecesidadManejador actualizarNecesidadManejador, EliminarNecesidadManejador eliminarNecesidadManejador, EliminarNecesidadPorAdministradorManejador eliminarNecesidadPorAdministradorManejador, AprobarProyectoManejador aprobarProyectoManejador, AprobarProyectoPorRolIngenieriaManejador aprobarProyectoPorRolIngenieriaManejador, AprobarProyectoPorRolLiderDeEquipoManejador aprobarProyectoPorRolLiderDeEquipoManejador, AprobarProyectoPorRolDirectorDeProyectoManejador aprobarProyectoPorRolDirectorDeProyectoManejador, GuardarRequerimientosManejador guardarRequerimientosManejador, ActualizarRequerimientosManejador actualizarRequerimientosManejador, RechazarProyectoManejador rechazarProyectoManejador) {
        this.guardarNecesidadManejador = guardarNecesidadManejador;
        this.actualizarNecesidadManejador = actualizarNecesidadManejador;
        this.eliminarNecesidadManejador = eliminarNecesidadManejador;
        this.eliminarNecesidadPorAdministradorManejador = eliminarNecesidadPorAdministradorManejador;
        this.aprobarProyectoManejador = aprobarProyectoManejador;
        this.aprobarProyectoPorRolIngenieriaManejador = aprobarProyectoPorRolIngenieriaManejador;
        this.aprobarProyectoPorRolLiderDeEquipoManejador = aprobarProyectoPorRolLiderDeEquipoManejador;
        this.aprobarProyectoPorRolDirectorDeProyectoManejador = aprobarProyectoPorRolDirectorDeProyectoManejador;
        this.guardarRequerimientosManejador = guardarRequerimientosManejador;
        this.actualizarRequerimientosManejador = actualizarRequerimientosManejador;
        this.rechazarProyectoManejador = rechazarProyectoManejador;
    }

    @PreAuthorize("hasRole('ROLE_ASOCIACION')")
    @PostMapping("/{id}")
    @Operation(summary = "Guardar Necesidad", description = "Este es usado para guardar una Necesidad en la aplicación por medio del ID de una asociacion")
    public ComandoRespuesta<Long> guardar(@RequestBody ProyectoComando proyectoComando, @PathVariable Long id) {
        return this.guardarNecesidadManejador.ejecutar(proyectoComando, id);
    }

    @PreAuthorize("hasRole('ROLE_ASOCIACION')")
    @PostMapping("/requerimientos/{id}")
    @Operation(summary = "Guardar Requerimientos", description = "Este es usado para guardar los requerimientos de una Necesidad en la aplicación por medio del ID de la necesidad")
    public ComandoRespuesta<Long> guardarRequerimientos(@RequestBody RequerimientosComando requerimientosComando, @PathVariable Long id) {
        return this.guardarRequerimientosManejador.ejecutar(requerimientosComando, id);
    }

    @PreAuthorize("hasRole('ROLE_ASOCIACION')")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Necesidad", description = "Este es usado para actualizar los datos de una Necesidad por medio del ID de una asociacion")
    public ComandoRespuesta<Long> actualizar(@RequestBody ProyectoComando proyectoComando, @PathVariable Long id) {
        return this.actualizarNecesidadManejador.ejecutar(proyectoComando, id);
    }

    @PreAuthorize("hasRole('ROLE_ASOCIACION')")
    @PutMapping("/requerimientos/{id}")
    @Operation(summary = "Actualizar Requerimientos", description = "Este es usado para actualizar los requerimientos de una Necesidad en la aplicación por medio del ID de la necesidad")
    public ComandoRespuesta<Long> actualizarRequerimientos(@RequestBody RequerimientosComando requerimientosComando, @PathVariable Long id) {
        return this.actualizarRequerimientosManejador.ejecutar(requerimientosComando, id);
    }

    @PreAuthorize("hasRole('ROLE_ASOCIACION')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Necesidad", description = "Este es usado para eliminar los datos de una necesidad por medio de su ID")
    public ComandoRespuesta<Long> eliminar(@PathVariable Long id) {
        return this.eliminarNecesidadManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @DeleteMapping("/administrador/{id}")
    @Operation(summary = "Eliminar Necesidad por Administrador", description = "Este es usado para que el administrador pueda eliminar los datos de una necesidad por medio del ID de la asociacion")
    public ComandoRespuesta<Long> eliminarPorAdministrador(@PathVariable Long id) {
        return this.eliminarNecesidadPorAdministradorManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @RequestMapping("/administrador/aprobar/{id}")
    @Operation(summary = "Aprobar Proyecto por Administrador", description = "Este es usado para que el administrador pueda aprobar una necesidad por medio de su ID")
    public ComandoRespuesta<Long> aprobarProyecto(@PathVariable Long id) {
        return this.aprobarProyectoManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @RequestMapping("/administrador/rechazar/{id}")
    @Operation(summary = "Rechazar Proyecto por Administrador", description = "Este es usado para que el administrador pueda rechazar una necesidad por medio de su ID")
    public ComandoRespuesta<Long> rechazarProyecto(@RequestBody MotivoRechazoNecesidadComando motivoRechazoNecesidadComando, @PathVariable Long id) {
        return this.rechazarProyectoManejador.ejecutar(motivoRechazoNecesidadComando, id);
    }

    @PreAuthorize("hasRole('ROLE_INGENIERIA')")
    @RequestMapping("/aprobacion/ingenieria/{id}")
    @Operation(summary = "Aprobar Proyecto por Rol Ingenieria", description = "Este es usado para que el usuario con el Rol de Ingenieria pueda aprobar el proyecto por medio de su ID")
    public ComandoRespuesta<Long> aprobarProyectoPorRolIngenieria(@PathVariable Long id) {
        return this.aprobarProyectoPorRolIngenieriaManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_LIDER_DEL_EQUIPO')")
    @RequestMapping("/aprobacion/liderDeEquipo/{id}")
    @Operation(summary = "Aprobar Proyecto por Rol Lider de Equipo", description = "Este es usado para que el usuario con el Rol de Lider de Equpo pueda aprobar el proyecto por medio de su ID")
    public ComandoRespuesta<Long> aprobarProyectoPorRolLiderDeEquipo(@PathVariable Long id) {
        return this.aprobarProyectoPorRolLiderDeEquipoManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_DIRECTOR_PROYECTO')")
    @RequestMapping("/aprobacion/directorDeProyecto/{id}")
    @Operation(summary = "Aprobar Proyecto por Rol Director de Proyecto", description = "Este es usado para que el usuario con el Rol de Director de Proyecto pueda aprobar el proyecto por medio de su ID")
    public ComandoRespuesta<Long> aprobarProyectoPorRolDirectorDeProyecto(HttpServletRequest peticion, @PathVariable Long id) {
        var token = peticion.getHeader(TextoConstante.HEADER_VALUE);

        return this.aprobarProyectoPorRolDirectorDeProyectoManejador.ejecutar(id, token);
    }
}