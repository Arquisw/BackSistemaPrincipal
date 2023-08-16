package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.proyecto.dto.*;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.*;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    @Autowired
    RequerimientosMapeador requerimientosMapeador;

    @Override
    public NecesidadDTO consultarPorAsociacionId(Long id) {
        var entidad = this.necesidadDAO.findByAsociacion(id);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        return this.necesidadMapeador.construirDTO(entidad);
    }

    @Override
    public NecesidadDTO consultarPorProyectoId(Long id) {
        var entidad = this.necesidadDAO.findAll().stream().filter(necesidad -> necesidad.getProyecto().getId().equals(id)).findFirst().orElse(null);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }

        var dto = this.necesidadMapeador.construirDTO(entidad);

        return dto;
    }

    @Override
    public RequerimientosDTO consultarRequerimientoPorNecesidadId(Long id) {
        var entidad = this.requerimientoArchivoDAO.findByNecesidad(id);

        if(ValidarObjeto.esNulo(entidad)) {
            return null;
        }
        return this.requerimientosMapeador.construirDTO(entidad);
    }

    @Override
    public List<NecesidadDTO> consultarNecesidadesPorId(Long id) {
        var entidades = this.necesidadDAO.findAll().stream().filter(necesidad -> Objects.equals(necesidad.getAsociacion(), id)).toList();

        return this.necesidadMapeador.construirDTOs(entidades);
    }

    @Override
    public NecesidadDTO consultarPorNecesidadId(Long id) {
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

        return this.necesidadMapeador.construirDTOs(necesidades);
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
    public List<NecesidadDTO> consultarProyectosAprobados() {
        var entidades = this.necesidadDAO.findAll();

        var necesidades = entidades.stream().filter(entidad -> entidad.getEstado().getEstado().getNombre().equals(TextoConstante.ESTADO_APROBADO)).toList();

        return this.necesidadMapeador.construirDTOs(necesidades);
    }

    @Override
    public List<NecesidadDTO> consultarProyectosNegociados() {
        var entidades = this.necesidadDAO.findAll();

        var necesidades = entidades.stream().filter(entidad -> entidad.getEstado().getEstado().getNombre().equals(TextoConstante.ESTADO_NEGOCIADO) && !entidad.getProyecto().getEstado().getEstado().getNombre().equals(TextoConstante.ESTADO_EN_DESARROLLO)).toList();

        return this.necesidadMapeador.construirDTOs(necesidades);
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