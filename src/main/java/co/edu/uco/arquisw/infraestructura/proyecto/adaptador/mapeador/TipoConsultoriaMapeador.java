package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.TipoConsultoriaDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.TipoConsultoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.TipoConsultoriaEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.TipoConsultoriaProyectoEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoConsultoriaMapeador {
    public TipoConsultoriaDTO construirDTO(TipoConsultoriaProyectoEntidad tipoConsultoria) {
        return new TipoConsultoriaDTO(tipoConsultoria.getTipoConsultoria().getNombre());
    }

    public List<TipoConsultoriaDTO> construirDTOs(List<TipoConsultoriaProyectoEntidad> roles) {
        return roles.stream().map(new TipoConsultoriaMapeador()::construirDTO).toList();
    }

    public TipoConsultoriaProyectoEntidad construirEntidad(TipoConsultoria tipoConsultoria) {
        return new TipoConsultoriaProyectoEntidad(0L, new TipoConsultoriaEntidad(obtenerRolID(tipoConsultoria.getNombre()), tipoConsultoria.getNombre()));
    }

    public List<TipoConsultoriaProyectoEntidad> construirEntidades(List<TipoConsultoria> tiposConsultoria) {
        return tiposConsultoria.stream().map(new TipoConsultoriaMapeador()::construirEntidad).toList();
    }

    private Long obtenerRolID(String nombre) {
        return switch (nombre) {
            case TextoConstante.INGENIERIA_DE_REQUISITOS -> 1L;
            case TextoConstante.SQA -> 2L;
            case TextoConstante.SQC -> 3L;
            default -> 0L;
        };
    }
}