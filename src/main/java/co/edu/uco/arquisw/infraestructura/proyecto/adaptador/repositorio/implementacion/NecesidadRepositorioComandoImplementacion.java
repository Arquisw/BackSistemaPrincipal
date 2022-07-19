package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.RequerimientoArchivoEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.NecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.PeticionEliminacionNecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NecesidadRepositorioComandoImplementacion implements NecesidadRepositorioComando
{
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


    @Override
    public Long guardar(Necesidad necesidad, Long asociacionID)
    {
        var entidad = this.necesidadMapeador.construirEntidad(necesidad, asociacionID);

        entidad.getProyecto().getTiposConsultoria().forEach(tipoConsultoria -> tipoConsultoria.setId(this.tipoConsultoriaProyectoDAO.save(tipoConsultoria).getId()));
        entidad.getProyecto().getEstado().setId(this.estadoProyectoDAO.save(entidad.getProyecto().getEstado()).getId());
        entidad.getProyecto().setId(this.proyectoDAO.save(entidad.getProyecto()).getId());
        entidad.getEstado().setId(this.estadoNecesidadDAO.save(entidad.getEstado()).getId());

        var id = this.necesidadDAO.save(entidad).getId();

        return this.requerimientoArchivoDAO.save(new RequerimientoArchivoEntidad(id, necesidad.getRutaArchivo(), id)).getId();
    }

    @Override
    public Long actualizar(Necesidad necesidad, Long asociacionID)
    {
        var entidad = this.necesidadDAO.findByAsociacion(asociacionID);
        var requerimientos = this.requerimientoArchivoDAO.findByNecesidad(entidad.getId());

        requerimientos.setRuta(necesidad.getRutaArchivo());
        entidad.getProyecto().setNombre(necesidad.getProyecto().getNombre());
        entidad.getProyecto().setDescripcion(necesidad.getProyecto().getDescripcion());

        this.requerimientoArchivoDAO.save(requerimientos);

        return this.necesidadDAO.save(entidad).getId();
    }

    @Override
    public void eliminar(Long id)
    {
        var entidad = this.necesidadDAO.findByAsociacion(id);

        this.estadoNecesidadDAO.deleteById(entidad.getEstado().getId());
        this.estadoProyectoDAO.deleteById(entidad.getProyecto().getEstado().getId());
        this.proyectoDAO.deleteById(entidad.getProyecto().getId());
        this.necesidadDAO.deleteById(entidad.getId());
    }

    @Override
    public void crearNotificacionEliminacion(Long id)
    {
        this.peticionEliminacionNecesidadDAO.save(this.peticionEliminacionNecesidadMapeador.construirEntidad(id));
    }
}