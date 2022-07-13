package co.edu.uco.arquisw.dominio.postulacion.puerto.consulta;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import java.util.List;

public interface PostulacionRepositorioConsulta
{
    PostulacionDTO consultarPostulacionPorId(Long id);
    List<PostulacionDTO> ConsultarPostulacionesPorProyecto(Long proyectoID);
    SeleccionDTO consultarSeleccionPorId(Long proyectoID);
    List<SeleccionDTO> consultarSeleccionadosPorProyecto(Long proyectoID);
}