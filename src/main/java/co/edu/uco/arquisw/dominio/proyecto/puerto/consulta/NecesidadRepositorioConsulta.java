package co.edu.uco.arquisw.dominio.proyecto.puerto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.AprobacionProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import java.util.List;

public interface NecesidadRepositorioConsulta {
    NecesidadDTO consultarPorId(Long id);
    NecesidadDTO consultarPorProyectoId(Long id);
    List<NecesidadDTO> consultarNecesidadesPorId(Long id);
    NecesidadDTO consultarPorNecesidad(Long id);
    List<NecesidadDTO> consultarNecesidades();
    ProyectoDTO consultarProyectoPorId(Long proyectoID);
    List<NecesidadDTO> consultarProyectos();
    List<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacionDeNecesidades();
    AprobacionProyectoDTO consultarAprobacionProyectoPorId(Long proyectoID);
}