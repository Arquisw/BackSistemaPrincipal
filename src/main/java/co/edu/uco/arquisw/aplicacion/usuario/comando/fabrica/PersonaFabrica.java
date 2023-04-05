package co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaFabrica {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final RolFabrica rolFabrica;

    public PersonaFabrica(PersonaRepositorioConsulta personaRepositorioConsulta, RolFabrica rolFabrica) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.rolFabrica = rolFabrica;
    }

    public Persona construir(PersonaComando persona) {
        return Persona.crear(persona.getNombre(), persona.getApellidos(), persona.getCorreo(), persona.getClave(), obtenerRolesPorDefecto());
    }

    public Persona construirActualizar(PersonaComando persona, Long id) {
        return Persona.crear(persona.getNombre(), persona.getApellidos(), persona.getCorreo(), persona.getClave(), obtenerRolesPorDefectoActualizar(id));
    }

    private List<Rol> obtenerRolesPorDefectoActualizar(Long id) {
        var persona = personaRepositorioConsulta.consultarPorId(id);

        if(ValidarObjeto.esNulo(persona)) {
            return new ArrayList<>();
        }

        return this.rolFabrica.construirTodos(persona.getRoles());
    }

    private List<Rol> obtenerRolesPorDefecto() {
        return List.of(Rol.crear(TextoConstante.ROL_USUARIO));
    }
}