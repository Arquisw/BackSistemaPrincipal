package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.RolProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.RolProyectoSeleccionEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolProyectoSeleccionMapeador {
    public String construirDTO(RolProyectoSeleccionEntidad rol) {
        return rol.getRol().getNombre();
    }

    public List<String> construirDTOs(List<RolProyectoSeleccionEntidad> roles) {
        return roles.stream().map(new RolProyectoSeleccionMapeador()::construirDTO).toList();
    }

    public RolProyectoSeleccionEntidad construirEntidad(String rol) {
        return new RolProyectoSeleccionEntidad(null, new RolProyectoEntidad(obtenerRolID(rol), rol));
    }

    public List<RolProyectoSeleccionEntidad> construirEntidades(List<String> roles) {
        return roles.stream().map(new RolProyectoSeleccionMapeador()::construirEntidad).toList();
    }

    private Long obtenerRolID(String nombre) {
        return switch (nombre) {
            case TextoConstante.ROL_DIRECTOR_PROYECTO -> NumeroConstante.UNO;
            case TextoConstante.ROL_PARTE_INTERESADA -> NumeroConstante.DOS;
            case TextoConstante.ROL_EQUIPO_DESARROLLO -> NumeroConstante.TRES;
            case TextoConstante.ROL_INGENIERIA -> NumeroConstante.CUATRO;
            case TextoConstante.ROL_ARQUITECTURA -> NumeroConstante.CINCO;
            case TextoConstante.ROL_ANALISTA -> NumeroConstante.SEIS;
            case TextoConstante.ROL_LIDER_DEL_EQUIPO -> NumeroConstante.SIETE;
            case TextoConstante.ROL_PATROCINADOR -> NumeroConstante.OCHO;
            default -> NumeroConstante.CERO;
        };
    }
}