package co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaActualizacionComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaFabrica {
    public Persona construir(PersonaComando persona) {
        return Persona.crear(persona.getNombre(), persona.getApellidos(), persona.getCorreo());
    }

    public Persona construirActualizar(PersonaActualizacionComando persona) {
        return Persona.crear(persona.getNombre(), persona.getApellidos(), persona.getCorreo());
    }
}