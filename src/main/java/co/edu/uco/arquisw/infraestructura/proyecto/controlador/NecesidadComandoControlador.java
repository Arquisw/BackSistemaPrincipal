package co.edu.uco.arquisw.infraestructura.proyecto.controlador;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.NecesidadComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.manejador.ActualizarNecesidadManejador;
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

    public NecesidadComandoControlador(GuardarNecesidadManejador guardarNecesidadManejador, ActualizarNecesidadManejador actualizarNecesidadManejador)
    {
        this.guardarNecesidadManejador = guardarNecesidadManejador;
        this.actualizarNecesidadManejador = actualizarNecesidadManejador;
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
}