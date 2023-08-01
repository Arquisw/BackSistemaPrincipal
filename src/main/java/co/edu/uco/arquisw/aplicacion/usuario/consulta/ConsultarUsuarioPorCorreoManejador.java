package co.edu.uco.arquisw.aplicacion.usuario.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.stereotype.Component;

@Component
public class ConsultarUsuarioPorCorreoManejador implements ManejadorComandoRespuesta<String, UsuarioDTO> {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarUsuarioPorCorreoManejador(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    @Override
    public UsuarioDTO ejecutar(String correo) {
        return this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo);
    }
}