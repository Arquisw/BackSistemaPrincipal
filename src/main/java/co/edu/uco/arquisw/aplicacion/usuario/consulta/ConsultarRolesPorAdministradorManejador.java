package co.edu.uco.arquisw.aplicacion.usuario.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultarRolesPorAdministradorManejador {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarRolesPorAdministradorManejador(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    @Transactional
    public List<RolDTO> ejecutar() {
        return personaRepositorioConsulta.consultarRolesPorAdministrador();
    }
}