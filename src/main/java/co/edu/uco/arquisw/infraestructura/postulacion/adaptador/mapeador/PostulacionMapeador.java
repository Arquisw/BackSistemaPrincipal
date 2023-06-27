package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.PostulacionEntidad;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.RolProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.RolProyectoPostulacionEntidad;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PostulacionMapeador {
    private final RolProyectoPostulacionMapeador rolProyectoPostulacionMapeador;

    public PostulacionMapeador(RolProyectoPostulacionMapeador rolProyectoPostulacionMapeador) {
        this.rolProyectoPostulacionMapeador = rolProyectoPostulacionMapeador;
    }

    public PostulacionDTO construirDTO(PostulacionEntidad postulacion) {
        return new PostulacionDTO(postulacion.getId(), postulacion.getFecha(), rolProyectoPostulacionMapeador.construirDTOs(postulacion.getRoles()), postulacion.getProyecto(), postulacion.getUsuario());
    }

    public List<PostulacionDTO> construirDTOs(List<PostulacionEntidad> postulaciones) {
        return postulaciones.stream().map(new PostulacionMapeador(rolProyectoPostulacionMapeador)::construirDTO).toList();
    }

    public PostulacionEntidad construirEntidad(Postulacion postulacion, Long proyectoID, Long usuarioID) {
        return new PostulacionEntidad(0L, postulacion.isSeleccionado(), FechaFormateador.obtenerFechaTexto(postulacion.getFecha()), rolProyectoPostulacionMapeador.construirEntidades(postulacion.getRoles()), proyectoID, usuarioID);
    }

    public void actualizarEntidad(PostulacionEntidad entidad, Postulacion postulacion, Long proyectoId, Long usuarioId) {
        actualizarRolesEntidad(entidad.getRoles(), postulacion.getRoles());
        entidad.setProyecto(proyectoId);
        entidad.setFecha(FechaFormateador.obtenerFechaTexto(postulacion.getFecha()));
        entidad.setUsuario(usuarioId);
    }

    private void actualizarRolesEntidad(List<RolProyectoPostulacionEntidad> rolesEntidad, List<String> roles) {
        for (RolProyectoPostulacionEntidad rolEntidad : rolesEntidad) {
            if (rolesEntidad.indexOf(rolEntidad) < roles.size()) {
                var nuevoNombre = roles.get(rolesEntidad.indexOf(rolEntidad));

                rolEntidad.getRol().setNombre(nuevoNombre);
            } else {
                var nuevoRol = new RolProyectoEntidad();

                nuevoRol.setId(0L);
                nuevoRol.setNombre(roles.get(roles.size() - 1));
                rolEntidad.setRol(nuevoRol);
            }
        }
    }
}