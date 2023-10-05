package co.edu.uco.arquisw.dominio.proyecto.puerto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.RequerimientosDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NecesidadRepositorioConsulta {
    NecesidadDTO consultarPorAsociacionId(Long id);

    NecesidadDTO consultarPorProyectoId(Long id);

    RequerimientosDTO consultarRequerimientoPorNecesidadId(Long id);

    List<NecesidadDTO> consultarNecesidadesPorId(Long id);

    NecesidadDTO consultarPorNecesidadId(Long id);

    List<NecesidadDTO> consultarNecesidades();
    Page<NecesidadDTO> consultarNecesidadesPaginado(int pagina, int tamano);

    ProyectoDTO consultarProyectoPorId(Long proyectoID);

    List<NecesidadDTO> consultarProyectosAprobados();

    Page<NecesidadDTO> consultarProyectosAprobadosPaginado(int pagina, int tamano);

    List<NecesidadDTO> consultarProyectosNegociados();

    List<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacionDeNecesidades();

    Page<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacionDeNecesidadesPaginado(int pagina, int tamano);
}