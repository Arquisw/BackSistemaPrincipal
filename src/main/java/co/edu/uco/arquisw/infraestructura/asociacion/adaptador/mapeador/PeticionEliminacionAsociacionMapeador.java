package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.asociacion.dto.PeticionEliminacionAsociacionDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.entidad.PeticionEliminacionAsociacionEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.PeticionEliminacionNecesidadEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.PeticionEliminacionNecesidadMapeador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeticionEliminacionAsociacionMapeador {
    public PeticionEliminacionAsociacionDTO construirDTO(PeticionEliminacionAsociacionEntidad peticionEliminacion) {
        return new PeticionEliminacionAsociacionDTO(peticionEliminacion.getId(), peticionEliminacion.getAsociacion());
    }

    public List<PeticionEliminacionAsociacionDTO> construirDTOs(List<PeticionEliminacionAsociacionEntidad> peticionesEliminacion) {
        return peticionesEliminacion.stream().map(new PeticionEliminacionAsociacionMapeador()::construirDTO).toList();
    }

    public Page<PeticionEliminacionAsociacionDTO> construirDTOsPaginado(Page<PeticionEliminacionAsociacionEntidad> peticionesEliminacion) {
        var peticionesDto = peticionesEliminacion.getContent().stream().map(new PeticionEliminacionAsociacionMapeador()::construirDTO).toList();
        return new PageImpl<>(peticionesDto, peticionesEliminacion.getPageable(), peticionesEliminacion.getTotalElements());
    }

    public PeticionEliminacionAsociacionEntidad construirEntidad(Long asociacionId) {
        return new PeticionEliminacionAsociacionEntidad(0L, asociacionId);
    }
}