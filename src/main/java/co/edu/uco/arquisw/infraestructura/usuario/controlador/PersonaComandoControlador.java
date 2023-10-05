package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.*;
import co.edu.uco.arquisw.aplicacion.usuario.comando.manejador.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@AllArgsConstructor
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
    private final IniciarRecuperacionClaveManejador iniciarRecuperacionClaveManejador;
    private final RecuperarClaveManejador recuperarClaveManejador;
    private final ValidarCodigoRecuperacionClaveManejador validarCodigoRecuperacionClaveManejador;
    private final ActualizarRolPorAdministradorManejador actualizarRolPorAdministradorManejador;
    private final IniciarActivacionCuentaManejador iniciarActivacionCuentaManejador;
    private final ActivarCuentaManejador activarCuentaManejador;

    @PostMapping
    @Operation(summary = "Guardar Usuario", description = "Este es usado para guardar un usuario en la aplicación")
    public ComandoRespuesta<Long> guardar(@RequestBody PersonaComando persona) {
        return this.guardarPersonaManejador.ejecutar(persona);
    }

    @PreAuthorize("hasAuthority('USUARIO_ESCRITURA')")
    @PostMapping("/hojadevida/{id}")
    @Operation(summary = "Guardar Hoja de Vida", description = "Este es usado para guardar una hoja en la aplicación por medio de un usuario")
    public ComandoRespuesta<Long> guardarHojaDeVida(@RequestBody HojaVidaComando hojaVidaComando, @PathVariable Long id) {
        return this.guardarHojaDeVidaManejador.ejecutar(hojaVidaComando, id);
    }

    @PreAuthorize("hasAuthority('USUARIO_ACTUALIZACION')")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario", description = "Este es usado para actualizar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> actualizar(@RequestBody PersonaActualizacionComando persona, @PathVariable Long id) {
        return this.actualizarPersonaManejador.ejecutar(persona, id);
    }

    @PreAuthorize("hasAuthority('USUARIO_ACTUALIZACION')")
    @PutMapping("/clave/{id}")
    @Operation(summary = "Actualizar Clave", description = "Este es usado para actualizar la contraseña de un usuario por medio de su ID")
    public ComandoRespuesta<Long> actualizarClave(@RequestBody ClaveActualizacionComando claveActualizacion, @PathVariable Long id) {
        return this.actualizarClaveManejador.ejecutar(claveActualizacion, id);
    }

    @PreAuthorize("hasAuthority('USUARIO_ACTUALIZACION')")
    @PutMapping("/hojadevida/{id}")
    @Operation(summary = "Actualizar Hoja de Vida", description = "Este es usado para actualizar los datos de una hoja de vida por medio del ID de un usuario")
    public ComandoRespuesta<Long> actualizarHojaDeVida(@RequestBody HojaVidaComando hojaVidaComando, @PathVariable Long id) {
        return this.actualizarHojaDeVidaManejador.ejecutar(hojaVidaComando, id);
    }

    @PreAuthorize("hasAuthority('USUARIO_ELIMINACION')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Usuario", description = "Este es usado para eliminar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> eliminar(@PathVariable Long id) {
        return this.eliminarPersonaManejador.ejecutar(id);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR_ELIMINACION')")
    @DeleteMapping("/administrador/{id}")
    @Operation(summary = "Eliminar Usuario por Administrador", description = "Este es usado para que el administrador pueda eliminar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> eliminarPorAdministrador(@PathVariable Long id) {
        return this.eliminarPersonaPorAdministradorManejador.ejecutar(id);
    }

    @PostMapping("/recuperacion/{correo}")
    @Operation(summary = "Iniciar Recuperación de la Clave", description = "Este es usado para generar el codigo unico que te permitira recuperar la cuenta")
    public ComandoRespuesta<Long> iniciarRecuperacionDeLaClave(@PathVariable String correo) {
        return this.iniciarRecuperacionClaveManejador.ejecutar(correo);
    }

    @PostMapping("/recuperacion/validarCodigo/{correo}")
    @Operation(summary = "Validar Codigo para Recuperar Clave", description = "Este es usado para validar que el codigo para recuperar la clave sea valido")
    public ComandoRespuesta<Boolean> validarCodigoParaRecuperarClave(@RequestBody ValidarCodigoRecuperacionClaveComando comando, @PathVariable String correo) {
        return this.validarCodigoRecuperacionClaveManejador.ejecutar(comando, correo);
    }

    @PostMapping("/recuperacion/recuperarClave/{correo}")
    @Operation(summary = "Recuperar Clave", description = "Este es usado para recuperar la clave, asignando una nueva clave.")
    public ComandoRespuesta<Long> recuperarClave(@RequestBody RecuperarClaveComando comando, @PathVariable String correo) {
        return this.recuperarClaveManejador.ejecutar(comando, correo);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR_ACTUALIZACION')")
    @PutMapping("/roles/{id}")
    @Operation(summary = "Actualizar Rol por Administrador", description = "Este es usado para actualizar permisos de un rol por medio del ID del rol")
    public ComandoRespuesta<Long> actualizarRol(@RequestBody RolActualizacionComando comando, @PathVariable Long id) {
        return this.actualizarRolPorAdministradorManejador.ejecutar(comando, id);
    }

    @PreAuthorize("hasAuthority('USUARIO_ESCRITURA')")
    @PostMapping("/activacion/{correo}")
    @Operation(summary = "Iniciar Activación de la cuenta", description = "Este es usado para generar el codigo unico que te permitira activar la cuenta")
    public ComandoRespuesta<Long> iniciarActivacionCuenta(@PathVariable String correo) {
        return this.iniciarActivacionCuentaManejador.ejecutar(correo);
    }

    @PreAuthorize("hasAuthority('USUARIO_ACTUALIZACION')")
    @PutMapping("/activacion/activar/{correo}")
    @Operation(summary = "Activar cuenta", description = "Este es usado para validar que el codigo para recuperar la clave sea valido y si lo es, activar la cuenta.")
    public ComandoRespuesta<Long> activarCuentaManejador(@RequestBody ActivarCuentaComando comando, @PathVariable String correo) {
        return this.activarCuentaManejador.ejecutar(comando, correo);
    }
}