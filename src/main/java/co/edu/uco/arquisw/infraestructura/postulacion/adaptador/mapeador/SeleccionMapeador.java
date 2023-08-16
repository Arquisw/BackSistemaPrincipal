package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.SeleccionEntidad;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeleccionMapeador {
    private final RolProyectoSeleccionMapeador rolProyectoSeleccionMapeador;
    @Autowired
    PersonaDAO personaDAO;

    public SeleccionMapeador(RolProyectoSeleccionMapeador rolProyectoSeleccionMapeador) {
        this.rolProyectoSeleccionMapeador = rolProyectoSeleccionMapeador;
    }

    public SeleccionDTO construirDTO(SeleccionEntidad seleccion, String nombre) {
        return new SeleccionDTO(seleccion.getId(), nombre, seleccion.getFecha(), rolProyectoSeleccionMapeador.construirDTOs(seleccion.getRoles()), seleccion.getProyecto(), seleccion.getUsuario());
    }

    public List<SeleccionDTO> construirDTOs(List<SeleccionEntidad> selecciones) {
        var seleccionesDTO = new ArrayList<SeleccionDTO>();

        for (var seleccion : selecciones) {
            var persona = this.personaDAO.findById(seleccion.getUsuario()).orElse(null);

            var nombre = TextoConstante.VACIO;

            if(persona != null) {
                nombre = persona.getNombre() + TextoConstante.ESPACIO + persona.getApellidos();
            }

            seleccionesDTO.add(construirDTO(seleccion, nombre));
        }

        return seleccionesDTO;
    }

    public SeleccionEntidad construirEntidad(Seleccion seleccion, Long proyectoID, Long usuarioID) {
        return new SeleccionEntidad(0L, FechaFormateador.obtenerFechaTexto(seleccion.getFecha()), rolProyectoSeleccionMapeador.construirEntidades(seleccion.getRoles()), proyectoID, usuarioID);
    }
}