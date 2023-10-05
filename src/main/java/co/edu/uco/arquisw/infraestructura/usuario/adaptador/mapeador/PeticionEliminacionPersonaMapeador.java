package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PeticionEliminacionPersonaDTO;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.PeticionEliminacionNecesidadEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.PeticionEliminacionNecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionEliminacionPersonaEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeticionEliminacionPersonaMapeador {
    public PeticionEliminacionPersonaDTO construirDTO(PeticionEliminacionPersonaEntidad peticionEliminacion) {
        return new PeticionEliminacionPersonaDTO(peticionEliminacion.getId(), peticionEliminacion.getUsuario());
    }

    public List<PeticionEliminacionPersonaDTO> construirDTOs(List<PeticionEliminacionPersonaEntidad> peticionesEliminacion) {
        return peticionesEliminacion.stream().map(new PeticionEliminacionPersonaMapeador()::construirDTO).toList();
    }

    public Page<PeticionEliminacionPersonaDTO> construirDTOsPaginado(Page<PeticionEliminacionPersonaEntidad> peticionesEliminacion) {
        var peticionesDto = peticionesEliminacion.getContent().stream().map(new PeticionEliminacionPersonaMapeador()::construirDTO).toList();
        return new PageImpl<>(peticionesDto, peticionesEliminacion.getPageable(), peticionesEliminacion.getTotalElements());
    }
    public PeticionEliminacionPersonaEntidad construirEntidad(Long usuarioID) {
        return new PeticionEliminacionPersonaEntidad(0L, usuarioID);
    }
}