package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarHojaDeVidaPorIdUsuarioManejador;
import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPersonaPorIdManejador;
import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPeticionesDeEliminacionPersonaManejador;
import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarUsuarioPorCorreoManejador;
import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PeticionEliminacionPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Consulta del Usuario Controlador")
public class PersonaConsultaControlador {
    private final ConsultarPersonaPorIdManejador consultarPersonaPorIdManejador;
    private final ConsultarHojaDeVidaPorIdUsuarioManejador consultarHojaDeVidaPorIdUsuarioManejador;
    private final ConsultarPeticionesDeEliminacionPersonaManejador consultarPeticionesDeEliminacionPersonaManejador;
    private final ConsultarUsuarioPorCorreoManejador consultarUsuarioPorCorreoManejador;

    public PersonaConsultaControlador(ConsultarPersonaPorIdManejador consultarPersonaPorIdManejador, ConsultarHojaDeVidaPorIdUsuarioManejador consultarHojaDeVidaPorIdUsuarioManejador, ConsultarPeticionesDeEliminacionPersonaManejador consultarPeticionesDeEliminacionPersonaManejador, ConsultarUsuarioPorCorreoManejador consultarUsuarioPorCorreoManejador) {
        this.consultarPersonaPorIdManejador = consultarPersonaPorIdManejador;
        this.consultarHojaDeVidaPorIdUsuarioManejador = consultarHojaDeVidaPorIdUsuarioManejador;
        this.consultarPeticionesDeEliminacionPersonaManejador = consultarPeticionesDeEliminacionPersonaManejador;
        this.consultarUsuarioPorCorreoManejador = consultarUsuarioPorCorreoManejador;
    }

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
    @Operation(summary = "Consultar todos", description = "Este es usado para consultar todas las peticiones de eliminnacion echas por los usuarios")
    public List<PeticionEliminacionPersonaDTO> consultarPeticionesDeEliminacion() {
        return this.consultarPeticionesDeEliminacionPersonaManejador.ejecutar();
    }
}