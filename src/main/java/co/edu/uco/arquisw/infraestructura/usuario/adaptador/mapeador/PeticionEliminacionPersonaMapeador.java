package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.usuario.dto.PeticionEliminacionPersonaDTO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionEliminacionPersonaEntidad;
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

    public PeticionEliminacionPersonaEntidad construirEntidad(Long usuarioID) {
        return new PeticionEliminacionPersonaEntidad(0L, usuarioID);
    }
}