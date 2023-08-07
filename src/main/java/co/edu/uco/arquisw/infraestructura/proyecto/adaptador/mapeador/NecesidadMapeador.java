package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.NecesidadEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa.RequerimientoArchivoDAO;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class NecesidadMapeador {
    private final EstadoNecesidadMapeador estadoNecesidadMapeador;
    private final ProyectoMapeador proyectoMapeador;
    private final RequerimientoArchivoDAO requerimientoArchivoDAO;

    public NecesidadMapeador(EstadoNecesidadMapeador estadoNecesidadMapeador, ProyectoMapeador proyectoMapeador, RequerimientoArchivoDAO requerimientoArchivoDAO) {
        this.estadoNecesidadMapeador = estadoNecesidadMapeador;
        this.proyectoMapeador = proyectoMapeador;
        this.requerimientoArchivoDAO = requerimientoArchivoDAO;
    }

    public NecesidadDTO construirDTO(NecesidadEntidad necesidad) {
        var requerimientoEntidad = this.requerimientoArchivoDAO.findByNecesidad(necesidad.getId());
        return new NecesidadDTO(necesidad.getId(), requerimientoEntidad.getRuta(), this.estadoNecesidadMapeador.construirDTO(necesidad.getEstado()), this.proyectoMapeador.construirDTO(necesidad.getProyecto()));
    }

    public List<NecesidadDTO> construirDTOs(List<NecesidadEntidad> necesidades) {
        return necesidades.stream().map(new NecesidadMapeador(estadoNecesidadMapeador, proyectoMapeador, requerimientoArchivoDAO)::construirDTO).toList();
    }

    public NecesidadEntidad construirEntidad(Necesidad necesidad, Long asociacionID) {
        return new NecesidadEntidad(0L, this.estadoNecesidadMapeador.construirEntidad(necesidad.getEstado()), this.proyectoMapeador.construirEntidad(necesidad.getProyecto()), asociacionID);
    }
}