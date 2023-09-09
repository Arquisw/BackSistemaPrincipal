package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.PostulacionEntidad;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.RolProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.RolProyectoPostulacionEntidad;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.MotivoRechazoPostulacionDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostulacionMapeador {
    private final RolProyectoPostulacionMapeador rolProyectoPostulacionMapeador;
    @Autowired
    MotivoRechazoPostulacionDAO motivoRechazoPostulacionDAO;
    @Autowired
    PersonaDAO personaDAO;

    public PostulacionMapeador(RolProyectoPostulacionMapeador rolProyectoPostulacionMapeador) {
        this.rolProyectoPostulacionMapeador = rolProyectoPostulacionMapeador;
    }

    public PostulacionDTO construirDTO(PostulacionEntidad postulacion, String nombre, String correo) {
        return new PostulacionDTO(postulacion.getId(), postulacion.isSeleccionado(), postulacion.isRechazado(), obtenerMotivoDelRechazo(postulacion.getId(), postulacion.isRechazado()), nombre, correo, postulacion.getFecha(), rolProyectoPostulacionMapeador.construirDTOs(postulacion.getRoles()), postulacion.getProyecto(), postulacion.getUsuario());
    }

    private String obtenerMotivoDelRechazo(Long id, boolean rechazado) {
        if (rechazado) {
            var motivoRechazo = this.motivoRechazoPostulacionDAO.findByPostulacion(id);

            assert motivoRechazo != null;
            return motivoRechazo.getMotivo();
        }

        return TextoConstante.VACIO;
    }

    public List<PostulacionDTO> construirDTOs(List<PostulacionEntidad> postulaciones) {
        var postulacionesDTO = new ArrayList<PostulacionDTO>();

        for (var postulacion : postulaciones) {
            var persona = this.personaDAO.findById(postulacion.getUsuario()).orElse(null);

            var nombre = TextoConstante.VACIO;
            var correo = TextoConstante.VACIO;

            if (persona != null) {
                nombre = persona.getNombre() + TextoConstante.ESPACIO + persona.getApellidos();
                correo = persona.getCorreo();
            }

            postulacionesDTO.add(construirDTO(postulacion, nombre, correo));
        }

        return postulacionesDTO;
    }

    public PostulacionEntidad construirEntidad(Postulacion postulacion, Long proyectoID, Long usuarioID) {
        return new PostulacionEntidad(0L, postulacion.isSeleccionado(), postulacion.isRechazado(), FechaFormateador.obtenerFechaTexto(postulacion.getFecha()), rolProyectoPostulacionMapeador.construirEntidades(postulacion.getRoles()), proyectoID, usuarioID);
    }

    public void actualizarEntidad(PostulacionEntidad entidad, Postulacion postulacion, Long proyectoId, Long usuarioId) {
        actualizarRolesEntidad(entidad.getRoles(), postulacion.getRoles());
        entidad.setProyecto(proyectoId);
        entidad.setFecha(FechaFormateador.obtenerFechaTexto(postulacion.getFecha()));
        entidad.setRechazado(postulacion.isRechazado());
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