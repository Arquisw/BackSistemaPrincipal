package co.edu.uco.arquisw.dominio.postulacion.puerto.consulta;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import java.util.List;

public interface PostulacionRepositorioConsulta
{
    PostulacionDTO consultarPostulacionPorId(Long id);
    PostulacionDTO consultarPostulacionPorUsuarioId(Long id);
    List<PostulacionDTO> consultarPostulacionesPorProyecto(Long proyectoID);
    SeleccionDTO consultarSeleccionPorId(Long id);
    SeleccionDTO consultarSeleccionPorUsuarioId(Long id);
    List<SeleccionDTO> consultarSeleccionadosPorProyecto(Long proyectoID);
}
