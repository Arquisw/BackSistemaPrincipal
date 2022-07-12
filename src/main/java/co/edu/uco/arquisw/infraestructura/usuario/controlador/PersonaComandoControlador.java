package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.manejador.ActualizarPersonaManejador;
import co.edu.uco.arquisw.aplicacion.usuario.comando.manejador.EliminarPersonaManejador;
import co.edu.uco.arquisw.aplicacion.usuario.comando.manejador.GuardarPersonaManejador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Comando del Usuario Controlador")
public class PersonaComandoControlador
{
    private final GuardarPersonaManejador guardarPersonaManejador;
    private final ActualizarPersonaManejador actualizarPersonaManejador;
    private final EliminarPersonaManejador eliminarPersonaManejador;

    public PersonaComandoControlador(GuardarPersonaManejador guardarPersonaManejador, ActualizarPersonaManejador actualizarPersonaManejador, EliminarPersonaManejador eliminarPersonaManejador)
    {
        this.guardarPersonaManejador = guardarPersonaManejador;
        this.actualizarPersonaManejador = actualizarPersonaManejador;
        this.eliminarPersonaManejador = eliminarPersonaManejador;
    }

    @PostMapping
    @Operation(summary = "Guardar Usuario", description = "Este es usado para guardar un usuario en la aplicación")
    public ComandoRespuesta<Long> guardar(@RequestBody PersonaComando persona)
    {
        return this.guardarPersonaManejador.ejecutar(persona);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario", description = "Este es usado para actualizar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> actualizar(@RequestBody PersonaComando persona, @PathVariable Long id)
    {
        return this.actualizarPersonaManejador.ejecutar(persona, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Usuario", description = "Este es usado para eliminar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> delete(@PathVariable Long id)
    {
        return this.eliminarPersonaManejador.ejecutar(id);
    }
}