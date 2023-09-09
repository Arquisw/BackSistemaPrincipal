package co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica;

import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolFabrica {
    public Rol construir(RolDTO rol) {
        return Rol.crear(rol.getNombre());
    }

    public List<Rol> construirTodos(List<RolDTO> roles) {
        return roles.stream().map(new RolFabrica()::construir).toList();
    }
}