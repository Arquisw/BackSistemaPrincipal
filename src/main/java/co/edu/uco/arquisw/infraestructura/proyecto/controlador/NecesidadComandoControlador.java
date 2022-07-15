package co.edu.uco.arquisw.infraestructura.proyecto.controlador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.NecesidadComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador.ActualizarNecesidadManejador;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador.EliminarNecesidadManejador;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador.EliminarNecesidadPorAdministradorManejador;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador.GuardarNecesidadManejador;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/necesidades")
@Tag(name = "Comando de la Necesidad Controlador")
public class NecesidadComandoControlador
{
    private final GuardarNecesidadManejador guardarNecesidadManejador;
    private final ActualizarNecesidadManejador actualizarNecesidadManejador;
    private final EliminarNecesidadManejador eliminarNecesidadManejador;
    private final EliminarNecesidadPorAdministradorManejador eliminarNecesidadPorAdministradorManejador;

    public NecesidadComandoControlador(GuardarNecesidadManejador guardarNecesidadManejador, ActualizarNecesidadManejador actualizarNecesidadManejador, EliminarNecesidadManejador eliminarNecesidadManejador, EliminarNecesidadPorAdministradorManejador eliminarNecesidadPorAdministradorManejador)
    {
        this.guardarNecesidadManejador = guardarNecesidadManejador;
        this.actualizarNecesidadManejador = actualizarNecesidadManejador;
        this.eliminarNecesidadManejador = eliminarNecesidadManejador;
        this.eliminarNecesidadPorAdministradorManejador = eliminarNecesidadPorAdministradorManejador;
    }

    @PostMapping("/{id}")
    @Operation(summary = "Guardar Necesidad", description = "Este es usado para guardar una Necesidad en la aplicación por medio del ID de una asociacion")
    public ComandoRespuesta<Long> guardar(@RequestBody NecesidadComando necesidad, @PathVariable Long id)
    {
        return this.guardarNecesidadManejador.ejecutar(necesidad, id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario", description = "Este es usado para actualizar los datos de una Necesidad por medio del ID de una asociacion")
    public ComandoRespuesta<Long> actualizar(@RequestBody NecesidadComando necesidad, @PathVariable Long id)
    {
        return this.actualizarNecesidadManejador.ejecutar(necesidad, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Necesidad", description = "Este es usado para eliminar los datos de una necesidad por medio del ID de una asociacion")
    public ComandoRespuesta<Long> eliminar(@PathVariable Long id)
    {
        return this.eliminarNecesidadManejador.ejecutar(id);
    }

    @DeleteMapping("/administrador/{id}")
    @Operation(summary = "Eliminar Necesidad por Administrador", description = "Este es usado para que el administrador pueda eliminar los datos de una necesidad por medio del ID de la asociacion")
    public ComandoRespuesta<Long> eliminarPorAdministrador(@PathVariable Long id)
    {
        return this.eliminarNecesidadPorAdministradorManejador.ejecutar(id);
    }
}