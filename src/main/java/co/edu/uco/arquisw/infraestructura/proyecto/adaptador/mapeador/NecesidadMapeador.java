package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.NecesidadEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.PeticionEliminacionNecesidadEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa.MotivoRechazoNecesidadDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NecesidadMapeador {
    private final EstadoNecesidadMapeador estadoNecesidadMapeador;
    private final ProyectoMapeador proyectoMapeador;
    private final MotivoRechazoNecesidadDAO motivoRechazoNecesidadDAO;


    public NecesidadMapeador(EstadoNecesidadMapeador estadoNecesidadMapeador, ProyectoMapeador proyectoMapeador, MotivoRechazoNecesidadDAO motivoRechazoNecesidadDAO) {
        this.estadoNecesidadMapeador = estadoNecesidadMapeador;
        this.proyectoMapeador = proyectoMapeador;
        this.motivoRechazoNecesidadDAO = motivoRechazoNecesidadDAO;
    }

    public NecesidadDTO construirDTO(NecesidadEntidad necesidad) {
        return new NecesidadDTO(necesidad.getId(), obtenerMotivoRechazo(necesidad), this.estadoNecesidadMapeador.construirDTO(necesidad.getEstado()), this.proyectoMapeador.construirDTO(necesidad.getProyecto()), necesidad.getAsociacion());
    }

    private String obtenerMotivoRechazo(NecesidadEntidad necesidad) {
        if (necesidad.getEstado().getEstado().getNombre().equals(TextoConstante.ESTADO_RECHAZADO)) {
            return this.motivoRechazoNecesidadDAO.findByNecesidad(necesidad.getId()).getMotivo();
        }

        return TextoConstante.VACIO;
    }

    public List<NecesidadDTO> construirDTOs(List<NecesidadEntidad> necesidades) {
        return necesidades.stream().map(new NecesidadMapeador(estadoNecesidadMapeador, proyectoMapeador, motivoRechazoNecesidadDAO)::construirDTO).toList();
    }

    public Page<NecesidadDTO> construirDTOsPaginado(Page<NecesidadEntidad> necesidades) {
        var necesidad = necesidades.getContent().stream().map(new NecesidadMapeador(estadoNecesidadMapeador, proyectoMapeador, motivoRechazoNecesidadDAO)::construirDTO).toList();
        return new PageImpl<>(necesidad, necesidades.getPageable(), necesidades.getTotalElements());
    }

    public NecesidadEntidad construirEntidad(Necesidad necesidad, Long asociacionID) {
        return new NecesidadEntidad(0L, this.estadoNecesidadMapeador.construirEntidad(necesidad.getEstado()), this.proyectoMapeador.construirEntidad(necesidad.getProyecto()), asociacionID);
    }
}