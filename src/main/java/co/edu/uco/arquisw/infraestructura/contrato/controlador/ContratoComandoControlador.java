package co.edu.uco.arquisw.infraestructura.contrato.controlador;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;
import co.edu.uco.arquisw.aplicacion.contrato.comando.manejador.ActualizarContratoManejador;
import co.edu.uco.arquisw.aplicacion.contrato.comando.manejador.EliminarContratoManejador;
import co.edu.uco.arquisw.aplicacion.contrato.comando.manejador.GuardarContratoManejador;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contratos")
@Tag(name = "Comando del Contrato Controlador")
public class ContratoComandoControlador
{
    private final GuardarContratoManejador guardarContratoManejador;
    private final ActualizarContratoManejador actualizarContratoManejador;
    private final EliminarContratoManejador eliminarContratoManejador;

    public ContratoComandoControlador(GuardarContratoManejador guardarContratoManejador, ActualizarContratoManejador actualizarContratoManejador, EliminarContratoManejador eliminarContratoManejador)
    {
        this.guardarContratoManejador = guardarContratoManejador;
        this.actualizarContratoManejador = actualizarContratoManejador;
        this.eliminarContratoManejador = eliminarContratoManejador;
    }

    @PostMapping("/{id}")
    @Operation(summary = "Guardar Contrato", description = "Este es usado para guardar un contrato en la aplicación por medio del ID de una asociacion")
    public ComandoRespuesta<Long> guardar(@RequestBody ContratoComando contrato, @PathVariable Long id)
    {
        return this.guardarContratoManejador.ejecutar(contrato, id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Asociacion", description = "Este es usado para actualizar los datos de un contrato por medio del ID de una asociacion")
    public ComandoRespuesta<Long> actualizar(@RequestBody ContratoComando contrato, @PathVariable Long id)
    {
        return this.actualizarContratoManejador.ejecutar(contrato, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Asociacion", description = "Este es usado para eliminar los datos de un contrato por medio del ID del usuario")
    public ComandoRespuesta<Long> eliminar(@PathVariable Long id)
    {
        return this.eliminarContratoManejador.ejecutar(id);
    }
}
