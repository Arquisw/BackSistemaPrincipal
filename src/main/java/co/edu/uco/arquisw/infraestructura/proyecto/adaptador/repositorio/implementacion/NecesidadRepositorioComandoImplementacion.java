package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.TipoConsultoria;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.infraestructura.contrato.adaptador.repositorio.jpa.ContratoDAO;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.RequerimientoArchivoEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.TipoConsultoriaProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.EstadoNecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.NecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.PeticionEliminacionNecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.TipoConsultoriaMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
    ContratoDAO contratoDAO;

    @Override
    public Long guardar(Necesidad necesidad, Long asociacionID) {
        var entidad = this.necesidadMapeador.construirEntidad(necesidad, asociacionID);

        entidad.getProyecto().getTiposConsultoria().forEach(tipoConsultoria -> tipoConsultoria.setId(this.tipoConsultoriaProyectoDAO.save(tipoConsultoria).getId()));
        entidad.getProyecto().getEstado().setId(this.estadoProyectoDAO.save(entidad.getProyecto().getEstado()).getId());
        entidad.getProyecto().setId(this.proyectoDAO.save(entidad.getProyecto()).getId());
        entidad.getEstado().setId(this.estadoNecesidadDAO.save(entidad.getEstado()).getId());

        var id = this.necesidadDAO.save(entidad).getId();

        return this.requerimientoArchivoDAO.save(new RequerimientoArchivoEntidad(id, necesidad.getRutaArchivo(), id)).getId();
    }

    @Override
    public Long actualizar(Necesidad necesidad, Long asociacionID) {
        var entidad = this.necesidadDAO.findByAsociacion(asociacionID);
        var requerimientos = this.requerimientoArchivoDAO.findByNecesidad(entidad.getId());

        requerimientos.setRuta(necesidad.getRutaArchivo());
        actualizarTipoConsultoria(necesidad.getProyecto().getTiposConsultoria(), entidad.getProyecto().getTiposConsultoria());
        entidad.getProyecto().getTiposConsultoria().forEach(tipoConsultoria -> tipoConsultoria.setId(this.tipoConsultoriaProyectoDAO.save(tipoConsultoria).getId()));
        entidad.getProyecto().setNombre(necesidad.getProyecto().getNombre());
        entidad.getProyecto().setDescripcion(necesidad.getProyecto().getDescripcion());

        this.proyectoDAO.save(entidad.getProyecto());

        var id = this.necesidadDAO.save(entidad).getId();

        this.requerimientoArchivoDAO.save(requerimientos);

        return id;
    }

    @Override
    public Long actualizarEstadoNecesidad(EstadoNecesidad estadoNecesidad, Long necesidadID) {
        var entidad = this.necesidadDAO.findById(necesidadID).orElse(null);

        var estado = this.estadoNecesidadMapeador.construirEntidad(estadoNecesidad);

        assert entidad != null;
        entidad.getEstado().setEstado(estado.getEstado());

        return this.necesidadDAO.save(entidad).getId();
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
        var entidad = this.necesidadDAO.findByAsociacion(id);
        var requerimientoEntidad = this.requerimientoArchivoDAO.findByNecesidad(id);
        var contrato = this.contratoDAO.findByNecesidad(id);

        this.estadoNecesidadDAO.deleteById(entidad.getEstado().getId());
        this.estadoProyectoDAO.deleteById(entidad.getProyecto().getEstado().getId());
        this.proyectoDAO.deleteById(entidad.getProyecto().getId());
        assert requerimientoEntidad != null;
        this.requerimientoArchivoDAO.deleteById(requerimientoEntidad.getId());
        this.necesidadDAO.deleteById(entidad.getId());
        assert contrato != null;
        this.contratoDAO.deleteById(contrato.getId());
    }

    @Override
    public void crearNotificacionEliminacion(Long id) {
        this.peticionEliminacionNecesidadDAO.save(this.peticionEliminacionNecesidadMapeador.construirEntidad(id));
    }
}