package co.edu.uco.arquisw.infraestructura.seguridad.controlador;

import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarHojaDeVidaPorIdUsuarioManejador;
import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPersonaPorCorreo;
import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPersonaPorIdManejador;
import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPeticionesDeEliminacionPersonaManejador;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.AccessException;
import java.security.Principal;

@RestController
@Tag(name = "Controlador para el login")
public class LoginComandoControlador {

    private final ConsultarPersonaPorCorreo consultarPersonaPorCorreo;

    public LoginComandoControlador(ConsultarPersonaPorCorreo consultarPersonaPorCorreo){


        this.consultarPersonaPorCorreo = consultarPersonaPorCorreo;
    }


    @RequestMapping("/login")
    @Operation(summary = "login", description = "Este es usado para confirmar el logeo exitoso de la cuenta")
    public PersonaDTO obtenerUsuarioTrasLogin(Principal usuario)
    {
        PersonaDTO personaDTO=consultarPersonaPorCorreo.ejecutar(usuario.getName());
        if (personaDTO!=null){
            return personaDTO;
        }
        else {
            //no se que poner por ahora, ni que excepcion, asi que lo dejare asi por el momento
            throw new RuntimeException("Error");
        }
    }
}
