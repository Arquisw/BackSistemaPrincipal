package co.edu.uco.arquisw.infraestructura.postulacion.controlador;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.MotivoRechazoPostulacionComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.SeleccionComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador.ActualizarPostulacionManejador;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador.GuardarPostulacionManejador;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador.RechazarUsuarioManejador;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador.SeleccionarUsuarioManejador;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/postulaciones")
@Tag(name = "Comando de la Postulacion Controlador")
public class PostulacionComandoControlador {
    private final GuardarPostulacionManejador guardarPostulacionManejador;
    private final ActualizarPostulacionManejador actualizarPostulacionManejador;
    private final SeleccionarUsuarioManejador seleccionarUsuarioManejador;
    private final RechazarUsuarioManejador rechazarUsuarioManejador;

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PostMapping
    @Operation(summary = "Guardar Postulación", description = "Este es usado para guardar una postulacion en la aplicación")
    public ComandoRespuesta<Long> guardar(@RequestBody PostulacionComando postulacion) {
        return this.guardarPostulacionManejador.ejecutar(postulacion);
    }

    @PreAuthorize("hasRole('ROLE_POSTULADO')")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Postulación", description = "Este es usado para actualizar una postulacion hecha en la aplicación por medio del ID de la postulacion")
    public ComandoRespuesta<Long> actualizar(@RequestBody PostulacionComando postulacion, @PathVariable Long id) {
        return this.actualizarPostulacionManejador.ejecutar(postulacion, id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("/administrador/seleccionar/{id}")
    @Operation(summary = "Seleccionar Usuario", description = "Este es usado para seleccionar a un usuario dentro de un proyecto por medio del ID de la postulación")
    public ComandoRespuesta<Long> seleccionarUsuario(@RequestBody SeleccionComando seleccionComando, @PathVariable Long id) {
        return this.seleccionarUsuarioManejador.ejecutar(seleccionComando, id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("/administrador/rechazar/{id}")
    @Operation(summary = "Rechazar Usuario", description = "Este es usado para rechazar a un usuario dentro de un proyecto por medio del ID de la postulación")
    public ComandoRespuesta<Long> rechazarUsuario(@RequestBody MotivoRechazoPostulacionComando motivoRechazoPostulacionComando, @PathVariable Long id) {
        return this.rechazarUsuarioManejador.ejecutar(motivoRechazoPostulacionComando, id);
    }
}