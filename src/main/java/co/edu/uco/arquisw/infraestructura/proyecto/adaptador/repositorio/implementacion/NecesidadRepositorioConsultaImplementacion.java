package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.proyecto.dto.AprobacionProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.ProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.AprobacionProyectoMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.NecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.PeticionEliminacionNecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.ProyectoMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class NecesidadRepositorioConsultaImplementacion implements NecesidadRepositorioConsulta {
    @Autowired
    NecesidadMapeador necesidadMapeador;
    @Autowired
    ProyectoMapeador proyectoMapeador;
    @Autowired
    ProyectoDAO proyectoDAO;
    @Autowired
    NecesidadDAO necesidadDAO;
    @Autowired
    RequerimientoArchivoDAO requerimientoArchivoDAO;
    @Autowired
    PeticionEliminacionNecesidadDAO peticionEliminacionNecesidadDAO;
    @Autowired
    PeticionEliminacionNecesidadMapeador peticionEliminacionNecesidadMapeador;
    @Autowired
    AprobacionProyectoDAO aprobacionProyectoDAO;
    @Autowired
    AprobacionProyectoMapeador aprobacionProyectoMapeador;

    @Override
    public NecesidadDTO consultarPorId(Long id) {
        var entidad = this.necesidadDAO.findByAsociacion(id);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        var requerimiento = this.requerimientoArchivoDAO.findByNecesidad(entidad.getId());

        var necesidad = this.necesidadMapeador.construirDTO(entidad);

        necesidad.setRutaArchivo(requerimiento.getRuta());

        return necesidad;
    }

    @Override
    public List<NecesidadDTO> consultarNecesidadesPorId(Long id) {
        var entidades = this.necesidadDAO.findAll().stream().filter(necesidad -> Objects.equals(necesidad.getAsociacion(), id)).toList();

        return this.necesidadMapeador.construirDTOs(entidades);
    }

    @Override
    public NecesidadDTO consultarPorNecesidad(Long id) {
        var entidad = this.necesidadDAO.findById(id).orElse(null);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.necesidadMapeador.construirDTO(entidad);
    }

    @Override
    public List<NecesidadDTO> consultarNecesidades() {
        var entidades = this.necesidadDAO.findAll();

        var necesidades = entidades.stream().filter(entidad -> entidad.getEstado().getEstado().getNombre().equals(TextoConstante.ESTADO_EN_ESPERA)).toList();

        var necesidadesDTO = this.necesidadMapeador.construirDTOs(necesidades);

        necesidadesDTO.forEach(dto -> dto.setRutaArchivo(this.requerimientoArchivoDAO.findByNecesidad(dto.getId()).getRuta()));

        return necesidadesDTO;
    }

    @Override
    public ProyectoDTO consultarProyectoPorId(Long proyectoID) {
        var entidad = this.proyectoDAO.findById(proyectoID).orElse(null);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.proyectoMapeador.construirDTO(entidad);
    }

    @Override
    public List<ProyectoDTO> consultarProyectos() {
        var entidades = this.necesidadDAO.findAll();

        var necesidades = entidades.stream().filter(entidad -> entidad.getEstado().getEstado().getNombre().equals(TextoConstante.ESTADO_NEGOCIADO)).toList();

        List<ProyectoEntidad> proyectos = new ArrayList<>();

        necesidades.forEach(necesidad -> proyectos.add(necesidad.getProyecto()));

        return this.proyectoMapeador.construirDTOs(proyectos);
    }

    @Override
    public List<PeticionEliminacionNecesidadDTO> consultarPeticionesDeEliminacionDeNecesidades() {
        var entidades = this.peticionEliminacionNecesidadDAO.findAll();

        return this.peticionEliminacionNecesidadMapeador.construirDTOs(entidades);
    }

    @Override
    public AprobacionProyectoDTO consultarAprobacionProyectoPorId(Long proyectoID) {
        var entidad = this.aprobacionProyectoDAO.findById(proyectoID).orElse(null);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.aprobacionProyectoMapeador.construirDTO(entidad);
    }
}