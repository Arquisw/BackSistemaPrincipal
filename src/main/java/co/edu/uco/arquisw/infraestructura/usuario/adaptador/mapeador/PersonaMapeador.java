package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PersonaEntidad;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapeador {

    public PersonaDTO construirDTO(PersonaEntidad persona) {
        return new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellidos(), persona.getCorreo());
    }

    public PersonaEntidad construirEntidad(Persona persona) {
        return new PersonaEntidad(0L, persona.getNombre(), persona.getApellidos(), persona.getCorreo());
    }

    public void actualizarEntidad(PersonaEntidad entidad, Persona persona) {
        entidad.setNombre(persona.getNombre());
        entidad.setCorreo(persona.getCorreo());
        entidad.setApellidos(persona.getApellidos());
    }
}