package co.edu.uco.arquisw.dominio.proyecto.puerto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import java.util.List;

public interface NecesidadRepositorioConsulta
{
    NecesidadDTO consultarPorId(Long id);
    List<NecesidadDTO> consultarNecesidades();
    ProyectoDTO consultarProyectoPorId(Long proyectoID);
    List<ProyectoDTO> consultarProyectos();
    List<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacionDeNecesidades();
}