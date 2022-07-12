package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.NecesidadMapeador;
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
    ProyectoDAO proyectoDAO;
    @Autowired
    NecesidadDAO necesidadDAO;

    @Override
    public Long guardar(Necesidad necesidad, Long asociacionID)
    {
        var entidad = this.necesidadMapeador.construirEntidad(necesidad, asociacionID);

        entidad.getProyecto().getTiposConsultoria().forEach(tipoConsultoria -> tipoConsultoria.setId(this.tipoConsultoriaProyectoDAO.save(tipoConsultoria).getId()));
        entidad.getProyecto().getEstado().setId(this.estadoProyectoDAO.save(entidad.getProyecto().getEstado()).getId());
        entidad.getProyecto().setId(this.proyectoDAO.save(entidad.getProyecto()).getId());
        entidad.getEstado().setId(this.estadoNecesidadDAO.save(entidad.getEstado()).getId());

        return this.necesidadDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Necesidad necesidad, Long asociacionID)
    {
        var entidad = this.necesidadDAO.findByAsociacion(asociacionID);

        entidad.setRutaArchivo(necesidad.getRutaArchivo());
        entidad.getProyecto().setNombre(necesidad.getProyecto().getNombre());
        entidad.getProyecto().setDescripcion(necesidad.getProyecto().getDescripcion());

        return this.necesidadDAO.save(entidad).getId();
    }
}