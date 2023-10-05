package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.PeticionEliminacionNecesidadEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeticionEliminacionNecesidadMapeador {
    public PeticionEliminacionNecesidadDTO construirDTO(PeticionEliminacionNecesidadEntidad peticionEliminacion) {
        return new PeticionEliminacionNecesidadDTO(peticionEliminacion.getId(), peticionEliminacion.getNecesidad());
    }

    public List<PeticionEliminacionNecesidadDTO> construirDTOs(List<PeticionEliminacionNecesidadEntidad> peticionesEliminacion) {
        return peticionesEliminacion.stream().map(new PeticionEliminacionNecesidadMapeador()::construirDTO).toList();
    }

    public Page<PeticionEliminacionNecesidadDTO> construirDTOsPaginado(Page<PeticionEliminacionNecesidadEntidad> peticionesEliminacion) {
        var peticionesDto = peticionesEliminacion.getContent().stream().map(new PeticionEliminacionNecesidadMapeador()::construirDTO).toList();
        return new PageImpl<>(peticionesDto, peticionesEliminacion.getPageable(), peticionesEliminacion.getTotalElements());
    }

    public PeticionEliminacionNecesidadEntidad construirEntidad(Long necesidadId) {
        return new PeticionEliminacionNecesidadEntidad(0L, necesidadId);
    }
}