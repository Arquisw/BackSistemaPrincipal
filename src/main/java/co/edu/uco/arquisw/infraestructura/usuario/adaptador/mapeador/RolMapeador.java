package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolEntidad;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolPersonaEntidad;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RolMapeador {
    public RolDTO construirDTO(RolPersonaEntidad rol)
    {
        return new RolDTO(rol.getRol().getNombre());
    }

    public List<RolDTO> construirDTOs(List<RolPersonaEntidad> roles) {
        return roles.stream().map(new RolMapeador()::construirDTO).toList();
    }

    public RolPersonaEntidad construirEntidad(Rol rol) {
        return new RolPersonaEntidad(null, new RolEntidad(obtenerRolID(rol.getNombre()), rol.getNombre()));
    }

    public List<RolPersonaEntidad> construirEntidades(List<Rol> roles) {
        return roles.stream().map(new RolMapeador()::construirEntidad).toList();
    }

    private Long obtenerRolID(String nombre) {
        return switch (nombre) {
            case TextoConstante.ROL_USUARIO -> 1L;
            case TextoConstante.ROL_ASOCIACION -> 2L;
            case TextoConstante.ROL_ADMINISTRADOR -> 3L;
            case TextoConstante.ROL_POSTULADO -> 4L;
            case TextoConstante.ROL_SELECCIONADO -> 5L;
            case TextoConstante.ROL_DIRECTOR_PROYECTO -> 6L;
            case TextoConstante.ROL_PARTE_INTERESADA -> 7L;
            case TextoConstante.ROL_TEAM_MEMBER -> 8L;
            case TextoConstante.ROL_INGENIERIA -> 9L;
            case TextoConstante.ROL_ARQUITECTURA -> 10L;
            case TextoConstante.ROL_ANALISTA -> 11L;
            case TextoConstante.ROL_TEAM_LEADER -> 12L;
            case TextoConstante.ROL_PATROCINADOR -> 13L;
            default -> 0L;
        };
    }
}