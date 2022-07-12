package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPersonaPorIdManejador;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Consulta del Usuario Controlador")
public class PersonaConsultaControlador
{
    private final ConsultarPersonaPorIdManejador consultarPersonaPorIdManejador;

    public PersonaConsultaControlador(ConsultarPersonaPorIdManejador consultarPersonaPorIdManejador)
    {
        this.consultarPersonaPorIdManejador = consultarPersonaPorIdManejador;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar un usuario por medio de un ID")
    public PersonaDTO consultarPorId(@PathVariable Long id)
    {
        return this.consultarPersonaPorIdManejador.ejecutar(id);
    }
}