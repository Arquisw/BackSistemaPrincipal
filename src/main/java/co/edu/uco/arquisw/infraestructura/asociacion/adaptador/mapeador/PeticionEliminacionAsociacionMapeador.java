package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.asociacion.dto.PeticionEliminacionAsociacionDTO;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.entidad.PeticionEliminacionAsociacionEntidad;
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

    public PeticionEliminacionAsociacionEntidad construirEntidad(Long asociacionId) {
        return new PeticionEliminacionAsociacionEntidad(0L, asociacionId);
    }
}