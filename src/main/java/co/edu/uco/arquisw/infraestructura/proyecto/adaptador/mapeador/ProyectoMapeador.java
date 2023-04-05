package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Proyecto;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.ProyectoEntidad;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProyectoMapeador {
    private final EstadoProyectoMapeador estadoProyectoMapeador;
    private final TipoConsultoriaMapeador tipoConsultoriaMapeador;

    public ProyectoMapeador(EstadoProyectoMapeador estadoProyectoMapeador, TipoConsultoriaMapeador tipoConsultoriaMapeador) {
        this.estadoProyectoMapeador = estadoProyectoMapeador;
        this.tipoConsultoriaMapeador = tipoConsultoriaMapeador;
    }

    public ProyectoDTO construirDTO(ProyectoEntidad proyecto) {
        return new ProyectoDTO(proyecto.getId(), proyecto.getNombre(), proyecto.getDescripcion(), this.estadoProyectoMapeador.construirDTO(proyecto.getEstado()), this.tipoConsultoriaMapeador.construirDTOs(proyecto.getTiposConsultoria()));
    }

    public List<ProyectoDTO> construirDTOs(List<ProyectoEntidad> proyectos) {
        return proyectos.stream().map(new ProyectoMapeador(estadoProyectoMapeador, tipoConsultoriaMapeador)::construirDTO).toList();
    }

    public ProyectoEntidad construirEntidad(Proyecto proyecto) {
        return new ProyectoEntidad(0L, proyecto.getNombre(), proyecto.getDescripcion(), this.estadoProyectoMapeador.construirEntidad(proyecto.getEstado()), this.tipoConsultoriaMapeador.construirEntidades(proyecto.getTiposConsultoria()));
    }
}