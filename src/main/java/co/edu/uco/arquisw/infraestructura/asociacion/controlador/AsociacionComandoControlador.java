package co.edu.uco.arquisw.infraestructura.asociacion.controlador;

import co.edu.uco.arquisw.aplicacion.asociacion.comando.AsociacionComando;
import co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador.ActualizarAsociacionManejador;
import co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador.EliminarAsociacionManejador;
import co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador.EliminarAsociacionPorAdministradorManejador;
import co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador.GuardarAsociacionManejador;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asociaciones")
@Tag(name = "Comando de la Asociacion Controlador")
public class AsociacionComandoControlador
{
    private final GuardarAsociacionManejador guardarAsociacionManejador;
    private final ActualizarAsociacionManejador actualizarAsociacionManejador;
    private final EliminarAsociacionManejador eliminarAsociacionManejador;
    private final EliminarAsociacionPorAdministradorManejador eliminarAsociacionPorAdministradorManejador;

    public AsociacionComandoControlador(GuardarAsociacionManejador guardarAsociacionManejador, ActualizarAsociacionManejador actualizarAsociacionManejador, EliminarAsociacionManejador eliminarAsociacionManejador, EliminarAsociacionPorAdministradorManejador eliminarAsociacionPorAdministradorManejador)
    {
        this.guardarAsociacionManejador = guardarAsociacionManejador;
        this.actualizarAsociacionManejador = actualizarAsociacionManejador;
        this.eliminarAsociacionManejador = eliminarAsociacionManejador;
        this.eliminarAsociacionPorAdministradorManejador = eliminarAsociacionPorAdministradorManejador;
    }
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PostMapping("/{id}")
    @Operation(summary = "Guardar Asociacion", description = "Este es usado para guardar una asociacion en la aplicación por medio del ID de un usuario")
    public ComandoRespuesta<Long> guardar(@RequestBody AsociacionComando asociacion, @PathVariable Long id)
    {
        return this.guardarAsociacionManejador.ejecutar(asociacion, id);
    }
    @PreAuthorize("hasRole('ROLE_ASOCIACION')")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Asociacion", description = "Este es usado para actualizar los datos de una asociacion por medio del ID del usuario")
    public ComandoRespuesta<Long> actualizar(@RequestBody AsociacionComando asociacion, @PathVariable Long id)
    {
        return this.actualizarAsociacionManejador.ejecutar(asociacion, id);
    }
    @PreAuthorize("hasRole('ROLE_ASOCIACION')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Asociacion", description = "Este es usado para eliminar los datos de una asociacion por medio del ID del usuario")
    public ComandoRespuesta<Long> eliminar(@PathVariable Long id)
    {
        return this.eliminarAsociacionManejador.ejecutar(id);
    }
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @DeleteMapping("/administrador/{id}")
    @Operation(summary = "Eliminar Asociacion por Administrador", description = "Este es usado para que el administrador pueda eliminar los datos de una asociacion por medio del ID del usuario")
    public ComandoRespuesta<Long> eliminarPorAdministrador(@PathVariable Long id)
    {
        return this.eliminarAsociacionPorAdministradorManejador.ejecutar(id);
    }
}