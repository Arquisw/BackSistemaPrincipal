package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarHojaDeVidaPorIdUsuarioManejador;
import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPersonaPorIdManejador;
import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPeticionesDeEliminacionPersonaManejador;
import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PeticionEliminacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Consulta del Usuario Controlador")
public class PersonaConsultaControlador
{
    private final ConsultarPersonaPorIdManejador consultarPersonaPorIdManejador;
    private final ConsultarHojaDeVidaPorIdUsuarioManejador consultarHojaDeVidaPorIdUsuarioManejador;
    private final ConsultarPeticionesDeEliminacionPersonaManejador consultarPeticionesDeEliminacionPersonaManejador;

    public PersonaConsultaControlador(ConsultarPersonaPorIdManejador consultarPersonaPorIdManejador, ConsultarHojaDeVidaPorIdUsuarioManejador consultarHojaDeVidaPorIdUsuarioManejador, ConsultarPeticionesDeEliminacionPersonaManejador consultarPeticionesDeEliminacionPersonaManejador)
    {
        this.consultarPersonaPorIdManejador = consultarPersonaPorIdManejador;
        this.consultarHojaDeVidaPorIdUsuarioManejador = consultarHojaDeVidaPorIdUsuarioManejador;
        this.consultarPeticionesDeEliminacionPersonaManejador = consultarPeticionesDeEliminacionPersonaManejador;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar un usuario por medio de un ID")
    public PersonaDTO consultarPorId(@PathVariable Long id)
    {
        return this.consultarPersonaPorIdManejador.ejecutar(id);
    }

    @GetMapping("/hojadevida/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una hoja de vida de un usuario por medio del ID del usuario")
    public HojaDeVidaPersonaDTO consultarHojaDeVidaPorId(@PathVariable Long id)
    {
        return this.consultarHojaDeVidaPorIdUsuarioManejador.ejecutar(id);
    }

    @GetMapping("/administrador")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una hoja de vida de un usuario por medio del ID del usuario")
    public List<PeticionEliminacionDTO> consultarPeticionesDeEliminacion()
    {
        return this.consultarPeticionesDeEliminacionPersonaManejador.ejecutar();
    }
}