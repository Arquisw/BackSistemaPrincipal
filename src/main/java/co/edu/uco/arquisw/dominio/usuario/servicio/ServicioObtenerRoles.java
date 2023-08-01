package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import java.util.ArrayList;
import java.util.List;

public class ServicioObtenerRoles  {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioObtenerRoles(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public List<Rol> obtenerRolesPorDefectoActualizar(String correo) {
        var usuario = personaRepositorioConsulta.consultarUsuarioPorCorreo(correo);

        if(ValidarObjeto.esNulo(usuario)) {
            return new ArrayList<>();
        }

        return this.construirTodos(usuario.getRoles());
    }

    public List<Rol> obtenerRolesPorDefecto() {
        return List.of(Rol.crear(TextoConstante.ROL_USUARIO));
    }

    private List<Rol> construirTodos(List<RolDTO> roles) {
        return roles.stream().map(new ServicioObtenerRoles(this.personaRepositorioConsulta)::construir).toList();
    }

    private Rol construir(RolDTO rol) {
        return Rol.crear(rol.getNombre());
    }
}
