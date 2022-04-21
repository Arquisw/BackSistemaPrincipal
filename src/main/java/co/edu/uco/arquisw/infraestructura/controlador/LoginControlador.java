package co.edu.uco.arquisw.infraestructura.controlador;

import co.edu.uco.arquisw.infraestructura.controlador.respuesta.Respuesta;
import co.edu.uco.arquisw.infraestructura.controlador.respuesta.enumerador.EstadoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginControlador
{
    @GetMapping
    public ResponseEntity<Respuesta<String>> IniciarSesion()
    {
        ResponseEntity<Respuesta<String>> responseEntity;
        Respuesta<String> respuesta = new Respuesta<>();


        respuesta.añadirMensaje("El logeo se realizo de manera existosa");
        respuesta.setEstado(EstadoRespuesta.EXITOSA);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}
