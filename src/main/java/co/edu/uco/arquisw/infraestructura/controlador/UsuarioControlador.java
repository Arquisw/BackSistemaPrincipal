package co.edu.uco.arquisw.infraestructura.controlador;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.aplicacion.servicio.usuario.*;
import co.edu.uco.arquisw.infraestructura.controlador.respuesta.Respuesta;
import co.edu.uco.arquisw.infraestructura.controlador.respuesta.enumerador.EstadoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador
{
    private final ServicioAplicacionConsultarUsuario servicioConsultarUsuario;
    private final ServicioAplicacionConsultarUsuarios servicioConsultarUsuarios;
    private final ServicioAplicacionConsultarUsuarioPorCorreo servicioConsultarUsuarioPorCorreo;
    private final ServicioAplicacionGuardarUsuario servicioGuardarUsuario;
    private final ServicioAplicacionModificarUsuario servicioModificarUsuario;
    private final ServicioAplicacionEliminarUsuario servicioEliminarUsuario;

    public UsuarioControlador(ServicioAplicacionConsultarUsuario servicioConsultarUsuario, ServicioAplicacionConsultarUsuarios servicioConsultarUsuarios, ServicioAplicacionConsultarUsuarioPorCorreo servicioConsultarUsuarioPorCorreo, ServicioAplicacionGuardarUsuario servicioGuardarUsuario, ServicioAplicacionModificarUsuario servicioModificarUsuario, ServicioAplicacionEliminarUsuario servicioEliminarUsuario)
    {
        this.servicioConsultarUsuario = servicioConsultarUsuario;
        this.servicioConsultarUsuarios = servicioConsultarUsuarios;
        this.servicioConsultarUsuarioPorCorreo = servicioConsultarUsuarioPorCorreo;
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioModificarUsuario = servicioModificarUsuario;
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    @PostMapping
    public ResponseEntity<Respuesta<UsuarioDTO>> guardar(@RequestBody UsuarioDTO usuario)
    {
        ResponseEntity<Respuesta<UsuarioDTO>> responseEntity;
        Respuesta<UsuarioDTO> respuesta = new Respuesta<>();

        servicioGuardarUsuario.guardar(usuario);

        respuesta.añadirMensaje("El usuario fue creado correctamente");
        respuesta.setEstado(EstadoRespuesta.EXITOSA);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Respuesta<UsuarioDTO>> actualizar(@RequestBody UsuarioDTO usuario, @PathVariable int codigo)
    {
        ResponseEntity<Respuesta<UsuarioDTO>> responseEntity;
        Respuesta<UsuarioDTO> respuesta = new Respuesta<>();

        servicioModificarUsuario.modificar(codigo, usuario);

        respuesta.añadirMensaje("El usuario fue modificado correctamente");
        respuesta.setEstado(EstadoRespuesta.EXITOSA);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Respuesta<UsuarioDTO>> eliminar(@PathVariable int codigo)
    {
        ResponseEntity<Respuesta<UsuarioDTO>> responseEntity;
        Respuesta<UsuarioDTO> respuesta = new Respuesta<>();

        servicioEliminarUsuario.eliminar(codigo);

        respuesta.añadirMensaje("El usuario fue eliminado correctamente");
        respuesta.setEstado(EstadoRespuesta.EXITOSA);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<Respuesta<UsuarioDTO>> consultar()
    {
        ResponseEntity<Respuesta<UsuarioDTO>> responseEntity;
        Respuesta<UsuarioDTO> respuesta = new Respuesta<>();

        respuesta.setDatos(this.servicioConsultarUsuarios.consultar());

        respuesta.añadirMensaje("Los usuarios fueron consultados exitosamente");
        respuesta.setEstado(EstadoRespuesta.EXITOSA);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Respuesta<UsuarioDTO>> consultar(@PathVariable int codigo)
    {
        ResponseEntity<Respuesta<UsuarioDTO>> responseEntity;
        Respuesta<UsuarioDTO> respuesta = new Respuesta<>();

        respuesta.setDatos((List<UsuarioDTO>) this.servicioConsultarUsuario.consultarPorCodigo(codigo));

        respuesta.añadirMensaje("El usuario fue consultado exitosamente");
        respuesta.setEstado(EstadoRespuesta.EXITOSA);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/usuario/{correo}")
    public ResponseEntity<Respuesta<UsuarioDTO>> consultar(@PathVariable String correo)
    {
        ResponseEntity<Respuesta<UsuarioDTO>> responseEntity;
        Respuesta<UsuarioDTO> respuesta = new Respuesta<>();

        List<UsuarioDTO> usuarios = new ArrayList<>();
        usuarios.add(this.servicioConsultarUsuarioPorCorreo.consultarPorCorreo(correo));

        respuesta.setDatos(usuarios);

        respuesta.añadirMensaje("El usuario fue consultado exitosamente");
        respuesta.setEstado(EstadoRespuesta.EXITOSA);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}