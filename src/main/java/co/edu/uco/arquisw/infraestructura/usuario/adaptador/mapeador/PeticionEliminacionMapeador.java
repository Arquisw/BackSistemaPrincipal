package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.usuario.dto.PeticionEliminacionDTO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionEliminacionEntidad;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PeticionEliminacionMapeador
{
    public PeticionEliminacionDTO construirDTO(PeticionEliminacionEntidad peticionEliminacion)
    {
        return new PeticionEliminacionDTO(peticionEliminacion.getId(), peticionEliminacion.getUsuario());
    }

    public List<PeticionEliminacionDTO> construirDTOs(List<PeticionEliminacionEntidad> peticionesEliminacion)
    {
        return peticionesEliminacion.stream().map(new PeticionEliminacionMapeador()::construirDTO).toList();
    }

    public PeticionEliminacionEntidad construirEntidad(Long usuarioID)
    {
        return new PeticionEliminacionEntidad(0L, usuarioID);
    }
}
