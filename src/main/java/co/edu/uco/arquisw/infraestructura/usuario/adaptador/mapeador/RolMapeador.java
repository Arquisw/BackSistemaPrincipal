package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolEntidad;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolUsuarioEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolMapeador {
    public RolDTO construirDTO(RolUsuarioEntidad rol) {
        return new RolDTO(rol.getId(), rol.getRol().getNombre(), rol.getRol().isLeer(), rol.getRol().isEscribir(), rol.getRol().isActualizar(), rol.getRol().isEliminar());
    }

    public RolDTO construirDTO(RolEntidad rol) {
        return new RolDTO(rol.getId(), rol.getNombre(), rol.isLeer(), rol.isEscribir(), rol.isActualizar(), rol.isEliminar());
    }

    public List<RolDTO> construirDTOs(List<RolUsuarioEntidad> roles) {
        return roles.stream().map(new RolMapeador()::construirDTO).toList();
    }

    public List<RolDTO> construirBaseDTOs(List<RolEntidad> roles) {
        return roles.stream().map(new RolMapeador()::construirDTO).toList();
    }

    public RolUsuarioEntidad construirEntidad(Rol rol) {
        return new RolUsuarioEntidad(null, new RolEntidad(obtenerRolID(rol.getNombre()), rol.getNombre(), obtenerPermisoLeer(rol.getNombre()), obtenerPermisoEscribir(rol.getNombre()), obtenerPermisoActualizar(rol.getNombre()), obtenerPermisoEliminar(rol.getNombre())));
    }

    public List<RolUsuarioEntidad> construirEntidades(List<Rol> roles) {
        return roles.stream().map(new RolMapeador()::construirEntidad).toList();
    }

    private Long obtenerRolID(String nombre) {
        return switch (nombre) {
            case TextoConstante.ROL_USUARIO -> NumeroConstante.UNO;
            case TextoConstante.ROL_ASOCIACION -> NumeroConstante.DOS;
            case TextoConstante.ROL_ADMINISTRADOR -> NumeroConstante.TRES;
            case TextoConstante.ROL_POSTULADO -> NumeroConstante.CUATRO;
            case TextoConstante.ROL_SELECCIONADO -> NumeroConstante.CINCO;
            case TextoConstante.ROL_DIRECTOR_PROYECTO -> NumeroConstante.SEIS;
            case TextoConstante.ROL_PARTE_INTERESADA -> NumeroConstante.SIETE;
            case TextoConstante.ROL_EQUIPO_DESARROLLO -> NumeroConstante.OCHO;
            case TextoConstante.ROL_INGENIERIA -> NumeroConstante.NUEVE;
            case TextoConstante.ROL_ARQUITECTURA -> NumeroConstante.DIEZ;
            case TextoConstante.ROL_ANALISTA -> NumeroConstante.ONCE;
            case TextoConstante.ROL_LIDER_DEL_EQUIPO -> NumeroConstante.DOCE;
            case TextoConstante.ROL_PATROCINADOR -> NumeroConstante.TRECE;
            default -> NumeroConstante.CERO;
        };
    }

    private boolean obtenerPermisoLeer(String nombre) {
        return switch (nombre) {
            case TextoConstante.ROL_DIRECTOR_PROYECTO,
                    TextoConstante.ROL_PARTE_INTERESADA,
                    TextoConstante.ROL_EQUIPO_DESARROLLO,
                    TextoConstante.ROL_INGENIERIA,
                    TextoConstante.ROL_ARQUITECTURA,
                    TextoConstante.ROL_ANALISTA,
                    TextoConstante.ROL_LIDER_DEL_EQUIPO,
                    TextoConstante.ROL_PATROCINADOR -> true;
            default -> false;
        };
    }

    private boolean obtenerPermisoEscribir(String nombre) {
        return switch (nombre) {
            case TextoConstante.ROL_SELECCIONADO,
                    TextoConstante.ROL_EQUIPO_DESARROLLO,
                    TextoConstante.ROL_INGENIERIA,
                    TextoConstante.ROL_ARQUITECTURA,
                    TextoConstante.ROL_LIDER_DEL_EQUIPO -> true;
            default -> false;
        };
    }

    private boolean obtenerPermisoActualizar(String nombre) {
        return switch (nombre) {
            case TextoConstante.ROL_SELECCIONADO,
                    TextoConstante.ROL_EQUIPO_DESARROLLO,
                    TextoConstante.ROL_INGENIERIA,
                    TextoConstante.ROL_ARQUITECTURA,
                    TextoConstante.ROL_LIDER_DEL_EQUIPO -> true;
            default -> false;
        };
    }

    private boolean obtenerPermisoEliminar(String nombre) {
        return switch (nombre) {
            case TextoConstante.ROL_SELECCIONADO,
                    TextoConstante.ROL_EQUIPO_DESARROLLO,
                    TextoConstante.ROL_INGENIERIA,
                    TextoConstante.ROL_ARQUITECTURA,
                    TextoConstante.ROL_LIDER_DEL_EQUIPO -> true;
            default -> false;
        };
    }
}