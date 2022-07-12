package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PersonaEntidad;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapeador
{
    private final RolMapeador rolMapeador;

    public PersonaMapeador(RolMapeador rolMapeador)
    {
        this.rolMapeador = rolMapeador;
    }

    public PersonaDTO construirDTO(PersonaEntidad persona)
    {
        return new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellidos(), persona.getCorreo(), this.rolMapeador.construirDTOs(persona.getRoles()));
    }

    public PersonaEntidad construirEntidad(Persona persona)
    {
        return new PersonaEntidad(0L, persona.getNombre(), persona.getApellidos(), persona.getCorreo(), this.rolMapeador.construirEntidades(persona.getRoles()));
    }
}
