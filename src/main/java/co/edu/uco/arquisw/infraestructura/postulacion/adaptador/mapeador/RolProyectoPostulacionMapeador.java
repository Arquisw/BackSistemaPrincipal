package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.RolProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.RolProyectoPostulacionEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolProyectoPostulacionMapeador {
    public String construirDTO(RolProyectoPostulacionEntidad rol) {
        return rol.getRol().getNombre();
    }

    public List<String> construirDTOs(List<RolProyectoPostulacionEntidad> roles) {
        return roles.stream().map(new RolProyectoPostulacionMapeador()::construirDTO).toList();
    }

    public RolProyectoPostulacionEntidad construirEntidad(String rol) {
        return new RolProyectoPostulacionEntidad(null, new RolProyectoEntidad(obtenerRolID(rol), rol));
    }

    public List<RolProyectoPostulacionEntidad> construirEntidades(List<String> roles) {
        return roles.stream().map(new RolProyectoPostulacionMapeador()::construirEntidad).toList();
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