package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.EstadoProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.EstadoEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.EstadoProyectoEntidad;
import org.springframework.stereotype.Component;

@Component
public class EstadoProyectoMapeador {
    public EstadoProyectoDTO construirDTO(EstadoProyectoEntidad estado) {
        return new EstadoProyectoDTO(estado.getEstado().getNombre());
    }

    public EstadoProyectoEntidad construirEntidad(EstadoProyecto estado) {
        return new EstadoProyectoEntidad(0L, new EstadoEntidad(obtenerRolID(estado.getNombre()), estado.getNombre()));
    }

    private Long obtenerRolID(String nombre) {
        return switch (nombre) {
            case TextoConstante.ESTADO_EN_PROCESO -> 5L;
            case TextoConstante.ESTADO_EN_DESARROLLO -> 6L;
            case TextoConstante.ESTADO_FINALIZADO -> 7L;
            default -> 0L;
        };
    }
}