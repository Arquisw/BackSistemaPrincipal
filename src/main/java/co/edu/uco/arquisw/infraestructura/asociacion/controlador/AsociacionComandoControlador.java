package co.edu.uco.arquisw.infraestructura.asociacion.controlador;

import co.edu.uco.arquisw.aplicacion.asociacion.comando.AsociacionComando;
import co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador.ActualizarAsociacionManejador;
import co.edu.uco.arquisw.aplicacion.asociacion.comando.manejador.GuardarAsociacionManejador;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asociaciones")
@Tag(name = "Comando de la Asociacion Controlador")
public class AsociacionComandoControlador
{
    private final GuardarAsociacionManejador guardarAsociacionManejador;
    private final ActualizarAsociacionManejador actualizarAsociacionManejador;

    public AsociacionComandoControlador(GuardarAsociacionManejador guardarAsociacionManejador, ActualizarAsociacionManejador actualizarAsociacionManejador)
    {
        this.guardarAsociacionManejador = guardarAsociacionManejador;
        this.actualizarAsociacionManejador = actualizarAsociacionManejador;
    }

    @PostMapping("/{id}")
    @Operation(summary = "Guardar Asociacion", description = "Este es usado para guardar una asociacion en la aplicación por medio del ID de un usuario")
    public ComandoRespuesta<Long> guardar(@RequestBody AsociacionComando asociacion, @PathVariable Long id)
    {
        return this.guardarAsociacionManejador.ejecutar(asociacion, id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario", description = "Este es usado para actualizar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> actualizar(@RequestBody AsociacionComando asociacion, @PathVariable Long id)
    {
        return this.actualizarAsociacionManejador.ejecutar(asociacion, id);
    }
}