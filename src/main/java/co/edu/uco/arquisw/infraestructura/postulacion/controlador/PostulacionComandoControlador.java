package co.edu.uco.arquisw.infraestructura.postulacion.controlador;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador.ActualizarPostulacionManejador;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador.GuardarPostulacionManejador;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postulaciones")
@Tag(name = "Comando de la Postulacion Controlador")
public class PostulacionComandoControlador
{
    private final GuardarPostulacionManejador guardarPostulacionManejador;
    private final ActualizarPostulacionManejador actualizarPostulacionManejador;

    public PostulacionComandoControlador(GuardarPostulacionManejador guardarPostulacionManejador, ActualizarPostulacionManejador actualizarPostulacionManejador)
    {
        this.guardarPostulacionManejador = guardarPostulacionManejador;
        this.actualizarPostulacionManejador = actualizarPostulacionManejador;
    }

    @PostMapping
    @Operation(summary = "Guardar Usuario", description = "Este es usado para guardar un usuario en la aplicación")
    public ComandoRespuesta<Long> guardar(@RequestBody PostulacionComando postulacion)
    {
        return this.guardarPostulacionManejador.ejecutar(postulacion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario", description = "Este es usado para actualizar los datos de una persona por medio de su ID")
    public ComandoRespuesta<Long> actualizar(@RequestBody PostulacionComando postulacion, @PathVariable Long id)
    {
        return this.actualizarPostulacionManejador.ejecutar(postulacion, id);
    }
}