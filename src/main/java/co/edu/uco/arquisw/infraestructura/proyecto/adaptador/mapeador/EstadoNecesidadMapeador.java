package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.EstadoNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.EstadoEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.EstadoNecesidadEntidad;
import org.springframework.stereotype.Component;

@Component
public class EstadoNecesidadMapeador {
    public EstadoNecesidadDTO construirDTO(EstadoNecesidadEntidad estado) {
        return new EstadoNecesidadDTO(estado.getEstado().getNombre());
    }

    public EstadoNecesidadEntidad construirEntidad(EstadoNecesidad estado) {
        return new EstadoNecesidadEntidad(0L, new EstadoEntidad(obtenerRolID(estado.getNombre()), estado.getNombre()));
    }

    private Long obtenerRolID(String nombre) {
        return switch (nombre) {
            case TextoConstante.ESTADO_EN_ESPERA -> 1L;
            case TextoConstante.ESTADO_APROBADO -> 2L;
            case TextoConstante.ESTADO_NEGOCIADO -> 3L;
            default -> 0L;
        };
    }
}