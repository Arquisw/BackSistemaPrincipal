package co.edu.uco.arquisw.dominio.proyecto.puerto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.*;

import java.util.List;

public interface NecesidadRepositorioConsulta {
    NecesidadDTO consultarPorAsociacionId(Long id);
    NecesidadDTO consultarPorProyectoId(Long id);
    RequerimientosDTO consultarRequerimientoPorNecesidadId(Long id);
    List<NecesidadDTO> consultarNecesidadesPorId(Long id);
    NecesidadDTO consultarPorNecesidadId(Long id);
    List<NecesidadDTO> consultarNecesidades();
    ProyectoDTO consultarProyectoPorId(Long proyectoID);
    List<NecesidadDTO> consultarProyectosAprobados();
    List<NecesidadDTO> consultarProyectosNegociados();
    List<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacionDeNecesidades();
}