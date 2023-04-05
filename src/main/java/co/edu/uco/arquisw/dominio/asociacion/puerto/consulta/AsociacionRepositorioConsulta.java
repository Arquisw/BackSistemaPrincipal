package co.edu.uco.arquisw.dominio.asociacion.puerto.consulta;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.dto.PeticionEliminacionAsociacionDTO;
import java.util.List;

public interface AsociacionRepositorioConsulta {
    AsociacionDTO consultarPorID(Long id);
    AsociacionDTO consultarPorNIT(String nit);
    List<PeticionEliminacionAsociacionDTO> consultarPeticionesDeEliminacionDeAsociaciones();
}