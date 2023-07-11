package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.ClaveActualizacionComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.HojaVidaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaActualizacionComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.manejador.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Comando del Usuario Controlador")
public class PersonaComandoControlador {
    private final GuardarPersonaManejador guardarPersonaManejador;
    private final ActualizarPersonaManejador actualizarPersonaManejador;
    private final EliminarPersonaManejador eliminarPersonaManejador;
    private final EliminarPersonaPorAdministradorManejador eliminarPersonaPorAdministradorManejador;
    private final GuardarHojaDeVidaManejador guardarHojaDeVidaManejador;
    private final ActualizarHojaDeVidaManejador actualizarHojaDeVidaManejador;
    private final ActualizarClaveManejador actualizarClaveManejador;

    public PersonaComandoControlador(GuardarPersonaManejador guardarPersonaManejador, ActualizarPersonaManejador actualizarPersonaManejador, EliminarPersonaManejador eliminarPersonaManejador, EliminarPersonaPorAdministradorManejador eliminarPersonaPorAdministradorManejador, GuardarHojaDeVidaManejador guardarHojaDeVidaManejador, ActualizarHojaDeVidaManejador actualizarHojaDeVidaManejador, ActualizarClaveManejador actualizarClaveManejador) {
        this.guardarPersonaManejador = guardarPersonaManejador;
        this.actualizarPersonaManejador = actualizarPersonaManejador;
        this.eliminarPersonaManejador = eliminarPersonaManejador;
        this.eliminarPersonaPorAdministradorManejador = eliminarPersonaPorAdministradorManejador;
        this.guardarHojaDeVidaManejador = guardarHojaDeVidaManejador;
        this.actualizarHojaDeVidaManejador = actualizarHojaDeVidaManejador;
        this.actualizarClaveManejador = actualizarClaveManejador;
    }

    @PostMapping
    @Operation(summary = "Guardar Usuario", description = "Este es usado para guardar un usuario en la aplicación")
    public ComandoRespuesta<Long> guardar(@RequestBody PersonaComando persona) {
        return this.guardarPersonaManejador.ejecutar(persona);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PostMapping("/hojadevida/{id}")
    @Operation(summary = "Guardar Hoja de Vida", description = "Este es usado para guardar una hoja en la aplicación por medio de un usuario")
    public ComandoRespuesta<Long> guardarHojaDeVida(@RequestBody HojaVidaComando hojaVidaComando, @PathVariable Long id) {
        return this.guardarHojaDeVidaManejador.ejecutar(hojaVidaComando, id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario", description = "Este es usado para actualizar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> actualizar(@RequestBody PersonaActualizacionComando persona, @PathVariable Long id) {
        return this.actualizarPersonaManejador.ejecutar(persona, id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PutMapping("/clave/{id}")
    @Operation(summary = "Actualizar Clave", description = "Este es usado para actualizar la contraseña de un usuario por medio de su ID")
    public ComandoRespuesta<Long> actualizarClave(@RequestBody ClaveActualizacionComando claveActualizacion, @PathVariable Long id) {
        return this.actualizarClaveManejador.ejecutar(claveActualizacion, id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PutMapping("/hojadevida/{id}")
    @Operation(summary = "Actualizar Hoja de Vida", description = "Este es usado para actualizar los datos de una hoja de vida por medio del ID de un usuario")
    public ComandoRespuesta<Long> actualizarHojaDeVida(@RequestBody HojaVidaComando hojaVidaComando, @PathVariable Long id) {
        return this.actualizarHojaDeVidaManejador.ejecutar(hojaVidaComando, id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Usuario", description = "Este es usado para eliminar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> eliminar(@PathVariable Long id) {
        return this.eliminarPersonaManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @DeleteMapping("/administrador/{id}")
    @Operation(summary = "Eliminar Usuario por Administrador", description = "Este es usado para que el administrador pueda eliminar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> eliminarPorAdministrador(@PathVariable Long id) {
        return this.eliminarPersonaPorAdministradorManejador.ejecutar(id);
    }
}