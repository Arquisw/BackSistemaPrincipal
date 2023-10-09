package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.aplicacion.usuario.consulta.*;
import co.edu.uco.arquisw.dominio.usuario.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
@Tag(name = "Consulta del Usuario Controlador")
public class PersonaConsultaControlador {
    private final ConsultarPersonaPorIdManejador consultarPersonaPorIdManejador;
    private final ConsultarHojaDeVidaPorIdUsuarioManejador consultarHojaDeVidaPorIdUsuarioManejador;
    private final ConsultarPeticionesDeEliminacionPersonaManejador consultarPeticionesDeEliminacionPersonaManejador;
    private final ConsultarUsuarioPorCorreoManejador consultarUsuarioPorCorreoManejador;
    private final ConsultarRolesPorAdministradorManejador consultarRolesPorAdministradorManejador;

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar un usuario por medio de un ID")
    public PersonaDTO consultarPorId(@PathVariable Long id) {
        return this.consultarPersonaPorIdManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/usuario/{correo}")
    @Operation(summary = "Consultar Usuario por Correo", description = "Este es usado para consultar un usuario por medio de un correo")
    public UsuarioDTO consultarUsuarioPorCorreo(@PathVariable String correo) {
        return this.consultarUsuarioPorCorreoManejador.ejecutar(correo);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/hojadevida/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una hoja de vida de un usuario por medio del ID del usuario")
    public HojaDeVidaPersonaDTO consultarHojaDeVidaPorId(@PathVariable Long id) {
        return this.consultarHojaDeVidaPorIdUsuarioManejador.ejecutar(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping("/administrador")
    @Operation(summary = "Consultar todas las Peticiones", description = "Este es usado para consultar todas las peticiones de eliminnacion echas por los usuarios")
    public Page<PeticionEliminacionPersonaDTO> consultarPeticionesDeEliminacion(@RequestParam(defaultValue = "0") int pagina,
                                                                                @RequestParam(defaultValue = "10") int tamano) {
        return this.consultarPeticionesDeEliminacionPersonaManejador.ejecutar(pagina, tamano);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping("/roles")
    @Operation(summary = "Consultar todos los Roles", description = "Este es usado para consultar todos los roles de la aplicacion")
    public List<RolDTO> consultarRolesPorAdministrador() {
        return this.consultarRolesPorAdministradorManejador.ejecutar();
    }
}