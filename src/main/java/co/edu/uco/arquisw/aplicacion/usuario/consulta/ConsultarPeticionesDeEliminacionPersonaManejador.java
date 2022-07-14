package co.edu.uco.arquisw.aplicacion.usuario.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.PeticionEliminacionDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultarPeticionesDeEliminacionPersonaManejador
{
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarPeticionesDeEliminacionPersonaManejador(PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    @Transactional
    public List<PeticionEliminacionDTO> ejecutar()
    {
        return personaRepositorioConsulta.consultarPeticionesDeEliminacionDeUsuarios();
    }
}