package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.proyecto.modelo.*;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.contrato.adaptador.repositorio.jpa.ContratoDAO;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.TipoConsultoriaProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.*;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Repository
public class NecesidadRepositorioComandoImplementacion implements NecesidadRepositorioComando {
    @Autowired
    NecesidadMapeador necesidadMapeador;
    @Autowired
    EstadoNecesidadDAO estadoNecesidadDAO;
    @Autowired
    EstadoProyectoDAO estadoProyectoDAO;
    @Autowired
    TipoConsultoriaProyectoDAO tipoConsultoriaProyectoDAO;
    @Autowired
    RequerimientoArchivoDAO requerimientoArchivoDAO;
    @Autowired
    ProyectoDAO proyectoDAO;
    @Autowired
    NecesidadDAO necesidadDAO;
    @Autowired
    PeticionEliminacionNecesidadMapeador peticionEliminacionNecesidadMapeador;
    @Autowired
    PeticionEliminacionNecesidadDAO peticionEliminacionNecesidadDAO;
    @Autowired
    TipoConsultoriaMapeador tipoConsultoriaMapeador;
    @Autowired
    EstadoNecesidadMapeador estadoNecesidadMapeador;
    @Autowired
    EstadoProyectoMapeador estadoProyectoMapeador;
    @Autowired
    ContratoDAO contratoDAO;
    @Autowired
    AprobacionProyectoDAO aprobacionProyectoDAO;
    @Autowired
    AprobacionProyectoMapeador aprobacionProyectoMapeador;
    @Autowired
    RequerimientosMapeador requerimientosMapeador;
    @Autowired
    MotivoRechazoNecesidadDAO motivoRechazoNecesidadDAO;
    @Autowired
    MotivoRechazoNecesidadMapeador motivoRechazoNecesidadMapeador;

    @Override
    public Long guardar(Necesidad necesidad, Long asociacionID) {
        var entidad = this.necesidadMapeador.construirEntidad(necesidad, asociacionID);

        entidad.getProyecto().getTiposConsultoria().forEach(tipoConsultoria -> tipoConsultoria.setId(this.tipoConsultoriaProyectoDAO.save(tipoConsultoria).getId()));
        entidad.getProyecto().getEstado().setId(this.estadoProyectoDAO.save(entidad.getProyecto().getEstado()).getId());
        entidad.getProyecto().getAprobacionProyecto().setId(this.aprobacionProyectoDAO.save(entidad.getProyecto().getAprobacionProyecto()).getId());
        entidad.getProyecto().setId(this.proyectoDAO.save(entidad.getProyecto()).getId());
        entidad.getEstado().setId(this.estadoNecesidadDAO.save(entidad.getEstado()).getId());

        return this.necesidadDAO.save(entidad).getId();
    }

    @Override
    public Long guardarRequerimientos(Requerimientos requerimientos, Long necesidadID) {
        var entidad = this.requerimientosMapeador.construirEntidad(requerimientos, necesidadID);

        return this.requerimientoArchivoDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Necesidad necesidad, Long asociacionID) {
        var entidad = this.necesidadDAO.findByAsociacion(asociacionID);

        actualizarTipoConsultoria(necesidad.getProyecto().getTiposConsultoria(), entidad.getProyecto().getTiposConsultoria());
        entidad.getProyecto().getTiposConsultoria().forEach(tipoConsultoria -> tipoConsultoria.setId(this.tipoConsultoriaProyectoDAO.save(tipoConsultoria).getId()));
        entidad.getProyecto().setNombre(necesidad.getProyecto().getNombre());
        entidad.getProyecto().setDescripcion(necesidad.getProyecto().getDescripcion());

        this.proyectoDAO.save(entidad.getProyecto());

        return this.necesidadDAO.save(entidad).getId();
    }

    @Override
    public Long actualizarRequerimientos(Requerimientos requerimientos, Long necesidadID) {
        var entidad = this.requerimientoArchivoDAO.findByNecesidad(necesidadID);

        entidad.setRuta(requerimientos.getRutaArchivo());

        return this.requerimientoArchivoDAO.save(entidad).getId();
    }

    @Override
    public Long actualizarEstadoNecesidad(EstadoNecesidad estadoNecesidad, Long necesidadID) {
        var entidad = this.necesidadDAO.findById(necesidadID).orElse(null);

        var estado = this.estadoNecesidadMapeador.construirEntidad(estadoNecesidad);

        assert entidad != null;
        entidad.getEstado().setEstado(estado.getEstado());

        return this.necesidadDAO.save(entidad).getId();
    }

    @Override
    public void actualizarEstadoProyecto(EstadoProyecto estadoProyecto, Long proyectoID) {
        var entidad = this.proyectoDAO.findById(proyectoID).orElse(null);

        var estado = this.estadoProyectoMapeador.construirEntidad(estadoProyecto);

        assert entidad != null;
        entidad.getEstado().setEstado(estado.getEstado());

        this.proyectoDAO.save(entidad);
    }

    private void actualizarTipoConsultoria(List<TipoConsultoria> tiposConsultoria, List<TipoConsultoriaProyectoEntidad> tiposConsultoriaEntidad) {
        agregarTiposConsultoria(tiposConsultoria, tiposConsultoriaEntidad);

        eliminarTiposConsultoria(tiposConsultoria, tiposConsultoriaEntidad);
    }

    public void agregarTiposConsultoria(List<TipoConsultoria> tiposConsultoria, List<TipoConsultoriaProyectoEntidad> tiposConsultoriaEntidad) {
        for (TipoConsultoria consultoria : tiposConsultoria) {
            var encontrado = false;

            for (TipoConsultoriaProyectoEntidad entidad : tiposConsultoriaEntidad) {
                if (entidad.getTipoConsultoria().getNombre().equals(consultoria.getNombre())) {
                    encontrado = true;
                    break;
                }

            }

            if (!encontrado && tiposConsultoriaEntidad.size() < 3) {
                var nuevaEntidad = this.tipoConsultoriaMapeador.construirEntidad(consultoria);
                tiposConsultoriaEntidad.add(nuevaEntidad);
            }
        }
    }

    public void eliminarTiposConsultoria(List<TipoConsultoria> tiposConsultoria, List<TipoConsultoriaProyectoEntidad> tiposConsultoriaEntidad) {
        Iterator<TipoConsultoriaProyectoEntidad> iter = tiposConsultoriaEntidad.iterator();

        while (iter.hasNext()) {
            TipoConsultoriaProyectoEntidad entidad = iter.next();
            boolean encontrado = false;
            for (TipoConsultoria consultoria : tiposConsultoria) {
                if (entidad.getTipoConsultoria().getNombre().equals(consultoria.getNombre())) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                iter.remove();
                this.tipoConsultoriaProyectoDAO.deleteById(entidad.getId());
            }
        }
    }

    @Override
    public void eliminar(Long id) {
        var entidad = this.necesidadDAO.findById(id).orElse(null);
        var requerimientoEntidad = this.requerimientoArchivoDAO.findByNecesidad(id);
        var contrato = this.contratoDAO.findByNecesidad(id);

        assert entidad != null;
        this.estadoNecesidadDAO.deleteById(entidad.getEstado().getId());
        this.estadoProyectoDAO.deleteById(entidad.getProyecto().getEstado().getId());
        this.proyectoDAO.deleteById(entidad.getProyecto().getId());
        assert requerimientoEntidad != null;
        this.requerimientoArchivoDAO.deleteById(requerimientoEntidad.getId());

        if (!ValidarObjeto.esNulo(contrato)) {
            this.contratoDAO.deleteById(contrato.getId());
        }

        this.necesidadDAO.deleteById(entidad.getId());
    }

    @Override
    public void eliminarPorAdministrador(Long id) {
        var entidad = this.necesidadDAO.findById(id).orElse(null);
        var requerimientoEntidad = this.requerimientoArchivoDAO.findByNecesidad(id);
        var contrato = this.contratoDAO.findByNecesidad(id);

        assert entidad != null;
        this.estadoNecesidadDAO.deleteById(entidad.getEstado().getId());
        this.estadoProyectoDAO.deleteById(entidad.getProyecto().getEstado().getId());
        this.proyectoDAO.deleteById(entidad.getProyecto().getId());
        assert requerimientoEntidad != null;
        this.requerimientoArchivoDAO.deleteById(requerimientoEntidad.getId());

        if (!ValidarObjeto.esNulo(contrato)) {
            this.contratoDAO.deleteById(contrato.getId());
        }

        var peticionEliminacionNecesidadEntidad = this.peticionEliminacionNecesidadDAO.findByNecesidad(id);

        this.peticionEliminacionNecesidadDAO.deleteById(peticionEliminacionNecesidadEntidad.getId());

        this.necesidadDAO.deleteById(entidad.getId());
    }
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void crearNotificacionEliminacion(Long id) {
        this.peticionEliminacionNecesidadDAO.save(this.peticionEliminacionNecesidadMapeador.construirEntidad(id));
    }

    @Override
    public Long actualizarAprobacionProyecto(Long proyectoID, String rol) {
        var entidad = this.aprobacionProyectoDAO.findById(proyectoID).orElse(null);

        assert entidad != null;
        aprobacionProyectoMapeador.construirEntidadActualizar(entidad, rol);

        return this.aprobacionProyectoDAO.save(entidad).getId();
    }

    @Override
    public Long guardarMotivoRechazoNecesidad(MotivoRechazoNecesidad motivoRechazoNecesidad, Long necesidadId) {
        var entidad = this.motivoRechazoNecesidadMapeador.construirEntidad(motivoRechazoNecesidad, necesidadId);

        return this.motivoRechazoNecesidadDAO.save(entidad).getId();
    }
}