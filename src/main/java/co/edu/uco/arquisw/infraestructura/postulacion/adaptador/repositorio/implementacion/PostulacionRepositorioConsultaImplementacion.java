package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador.PostulacionMapeador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador.SeleccionMapeador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.PostulacionDAO;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.SeleccionDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PostulacionRepositorioConsultaImplementacion implements PostulacionRepositorioConsulta {
    @Autowired
    PostulacionMapeador postulacionMapeador;
    @Autowired
    SeleccionMapeador seleccionMapeador;
    @Autowired
    PostulacionDAO postulacionDAO;
    @Autowired
    SeleccionDAO seleccionDAO;
    @Autowired
    PersonaDAO personaDAO;

    @Override
    public PostulacionDTO consultarPostulacionPorId(Long id) {
        var entidad = this.postulacionDAO.findById(id).orElse(null);

        if(entidad == null) {
            return null;
        }

        var persona = this.personaDAO.findById(entidad.getUsuario()).orElse(null);
        var nombre = TextoConstante.VACIO;
        var correo = TextoConstante.VACIO;

        if(persona != null) {
            nombre = persona.getNombre() + TextoConstante.ESPACIO + persona.getApellidos();
            correo = persona.getCorreo();
        }

        return this.postulacionMapeador.construirDTO(entidad, nombre, correo);
    }

    @Override
    public List<PostulacionDTO> consultarPostulacionesPorUsuarioId(Long id) {
        var entidades = this.postulacionDAO.findByUsuario(id).stream().sorted((postulacionUno, postulacionDos) -> {
            var fechaUno = FechaFormateador.obtenerFecha(postulacionUno.getFecha());
            var fechaDos = FechaFormateador.obtenerFecha(postulacionDos.getFecha());

            return fechaDos.compareTo(fechaUno);
        }).toList();

        return this.postulacionMapeador.construirDTOs(entidades);
    }

    @Override
    public List<PostulacionDTO> consultarPostulacionesPorProyecto(Long proyectoID) {
        var entidades = this.postulacionDAO.findAll();

        var postulaciones = entidades.stream().filter(entidad -> entidad.getId().equals(proyectoID) && !entidad.isRechazado() && !entidad.isSeleccionado()).toList();

        return this.postulacionMapeador.construirDTOs(postulaciones);
    }

    @Override
    public SeleccionDTO consultarSeleccionPorId(Long id) {
        var entidad = this.seleccionDAO.findById(id).orElse(null);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.seleccionMapeador.construirDTO(entidad);
    }

    @Override
    public List<SeleccionDTO> consultarSeleccionesPorUsuarioId(Long id) {
        var entidades = this.seleccionDAO.findByUsuario(id).stream().sorted((seleccionUno, seleccionDos) -> {
           var fechaUno = FechaFormateador.obtenerFecha(seleccionUno.getFecha());
           var fechaDos = FechaFormateador.obtenerFecha(seleccionDos.getFecha());

           return fechaDos.compareTo(fechaUno);
        }).toList();

        return this.seleccionMapeador.construirDTOs(entidades);
    }

    @Override
    public List<SeleccionDTO> consultarSeleccionadosPorProyecto(Long proyectoID) {
        var entidades = this.seleccionDAO.findAll();

        var selecciones = entidades.stream().filter(entidad -> entidad.getId().equals(proyectoID)).toList();

        return this.seleccionMapeador.construirDTOs(selecciones);
    }
}