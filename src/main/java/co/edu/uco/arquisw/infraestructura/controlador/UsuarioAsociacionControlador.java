package co.edu.uco.arquisw.infraestructura.controlador;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioAsociacionDTO;
import co.edu.uco.arquisw.aplicacion.servicio.usuarioasociacion.ServicioAplicacionGuardarUsuarioAsociacion;
import co.edu.uco.arquisw.infraestructura.controlador.respuesta.Respuesta;
import co.edu.uco.arquisw.infraestructura.controlador.respuesta.enumerador.EstadoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entidades")
public class UsuarioAsociacionControlador
{
    private final ServicioAplicacionGuardarUsuarioAsociacion servicioGuardarUsuarioAsociacion;

    public UsuarioAsociacionControlador(ServicioAplicacionGuardarUsuarioAsociacion servicioGuardarUsuarioAsociacion)
    {
        this.servicioGuardarUsuarioAsociacion = servicioGuardarUsuarioAsociacion;
    }

    @PostMapping
    @Secured("ROLE_USER")
    public ResponseEntity<Respuesta<UsuarioAsociacionDTO>> guardar(@RequestBody UsuarioAsociacionDTO usuarioAsociacionDTO)
    {
        ResponseEntity<Respuesta<UsuarioAsociacionDTO>> responseEntity;
        Respuesta<UsuarioAsociacionDTO> respuesta = new Respuesta<>();

        servicioGuardarUsuarioAsociacion.guardar(usuarioAsociacionDTO);

        respuesta.añadirMensaje("La Entidad fue creada correctamente");
        respuesta.setEstado(EstadoRespuesta.EXITOSA);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.OK);

        return responseEntity;
    }
}
