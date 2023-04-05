package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.PostulacionEntidad;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PostulacionMapeador {
    public PostulacionDTO construirDTO(PostulacionEntidad postulacion) {
        return new PostulacionDTO(postulacion.getId(), postulacion.getFecha(), postulacion.getRol(), postulacion.getProyecto(), postulacion.getUsuario());
    }

    public List<PostulacionDTO> construirDTOs(List<PostulacionEntidad> postulaciones) {
        return postulaciones.stream().map(new PostulacionMapeador()::construirDTO).toList();
    }

    public PostulacionEntidad construirEntidad(Postulacion postulacion, Long proyectoID, Long usuarioID) {
        return new PostulacionEntidad(0L, postulacion.isSeleccionado(), FechaFormateador.obtenerFechaTexto(postulacion.getFecha()), postulacion.getRol(), proyectoID, usuarioID);
    }

    public void actualizarEntidad(PostulacionEntidad entidad, Postulacion postulacion, Long proyectoId, Long usuarioId) {
        entidad.setRol(postulacion.getRol());
        entidad.setProyecto(proyectoId);
        entidad.setFecha(FechaFormateador.obtenerFechaTexto(postulacion.getFecha()));
        entidad.setUsuario(usuarioId);
    }
}