package co.edu.uco.arquisw.infraestructura.asociacion.controlador;

import co.edu.uco.arquisw.aplicacion.asociacion.consulta.ConsultarAsociacionPorIdManejador;
import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asociaciones")
@Tag(name = "Consulta de la Asociacion Controlador")
public class AsociacionConsultaControlador
{
    private final ConsultarAsociacionPorIdManejador consultarAsociacionPorIdManejador;

    public AsociacionConsultaControlador(ConsultarAsociacionPorIdManejador consultarAsociacionPorIdManejador)
    {
        this.consultarAsociacionPorIdManejador = consultarAsociacionPorIdManejador;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar por ID", description = "Este es usado para consultar una asociacion por medio del ID de un Usuario")
    public AsociacionDTO consultarPorId(@PathVariable Long id)
    {
        return this.consultarAsociacionPorIdManejador.ejecutar(id);
    }
}