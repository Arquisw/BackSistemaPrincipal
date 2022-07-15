package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.HojaVidaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.manejador.*;
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
    private final EliminarPersonaPorAdministradorManejador eliminarPersonaPorAdministradorManejador;
    private final GuardarHojaDeVidaManejador guardarHojaDeVidaManejador;
    private final ActualizarHojaDeVidaManejador actualizarHojaDeVidaManejador;

    public PersonaComandoControlador(GuardarPersonaManejador guardarPersonaManejador, ActualizarPersonaManejador actualizarPersonaManejador, EliminarPersonaManejador eliminarPersonaManejador, EliminarPersonaPorAdministradorManejador eliminarPersonaPorAdministradorManejador, GuardarHojaDeVidaManejador guardarHojaDeVidaManejador, ActualizarHojaDeVidaManejador actualizarHojaDeVidaManejador)
    {
        this.guardarPersonaManejador = guardarPersonaManejador;
        this.actualizarPersonaManejador = actualizarPersonaManejador;
        this.eliminarPersonaManejador = eliminarPersonaManejador;
        this.eliminarPersonaPorAdministradorManejador = eliminarPersonaPorAdministradorManejador;
        this.guardarHojaDeVidaManejador = guardarHojaDeVidaManejador;
        this.actualizarHojaDeVidaManejador = actualizarHojaDeVidaManejador;
    }

    @PostMapping
    @Operation(summary = "Guardar Usuario", description = "Este es usado para guardar un usuario en la aplicación")
    public ComandoRespuesta<Long> guardar(@RequestBody PersonaComando persona)
    {
        return this.guardarPersonaManejador.ejecutar(persona);
    }

    @PostMapping("/hojadevida/{id}")
    @Operation(summary = "Guardar Hoja de Vida", description = "Este es usado para guardar una hoja en la aplicación por medio de un usuario")
    public ComandoRespuesta<Long> guardarHojaDeVida(@RequestBody HojaVidaComando hojaVidaComando, @PathVariable Long id)
    {
        return this.guardarHojaDeVidaManejador.ejecutar(hojaVidaComando, id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario", description = "Este es usado para actualizar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> actualizar(@RequestBody PersonaComando persona, @PathVariable Long id)
    {
        return this.actualizarPersonaManejador.ejecutar(persona, id);
    }

    @PutMapping("/hojadevida/{id}")
    @Operation(summary = "Actualizar Hoja de Vida", description = "Este es usado para actualizar los datos de una hoja de vida por medio del ID de un usuario")
    public ComandoRespuesta<Long> actualizarHojaDeVida(@RequestBody HojaVidaComando hojaVidaComando, @PathVariable Long id)
    {
        return this.actualizarHojaDeVidaManejador.ejecutar(hojaVidaComando, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Usuario", description = "Este es usado para eliminar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> eliminar(@PathVariable Long id)
    {
        return this.eliminarPersonaManejador.ejecutar(id);
    }

    @DeleteMapping("/administrador/{id}")
    @Operation(summary = "Eliminar Usuario por Administrador", description = "Este es usado para que el administrador pueda eliminar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> eliminarPorAdministrador(@PathVariable Long id)
    {
        return this.eliminarPersonaPorAdministradorManejador.ejecutar(id);
    }
}