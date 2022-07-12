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

        entidad.setId(obtenerNecesidadID());
        entidad.getEstado().setId(obtenerEstadoNecesidadID());
        entidad.getProyecto().setId(obtenerProyectoID());
        entidad.getProyecto().getEstado().setId(obtenerEstadoProyectoID());
        entidad.getProyecto().getTiposConsultoria().forEach(tipoConsultoria -> tipoConsultoria.setId(obtenerTipoConsultoriaID()));

        return this.necesidadDAO.save(entidad).getId();
    }

    private Long obtenerNecesidadID()
    {
        var id = 1L;
        var necesidades = this.necesidadDAO.findAll();

        if(!necesidades.isEmpty())
        {
            id = necesidades.get(necesidades.size() - 1).getId() + 1L;
        }

        return id;
    }

    private Long obtenerEstadoNecesidadID()
    {
        var id = 1L;
        var estados = this.estadoNecesidadDAO.findAll();

        if(!estados.isEmpty())
        {
            id = estados.get(estados.size() - 1).getId() + 1L;
        }

        return id;
    }

    private Long obtenerProyectoID()
    {
        var id = 1L;
        var proyectos = this.proyectoDAO.findAll();

        if(!proyectos.isEmpty())
        {
            id = proyectos.get(proyectos.size() - 1).getId() + 1L;
        }

        return id;
    }

    private Long obtenerEstadoProyectoID()
    {
        var id = 1L;
        var estados = this.estadoProyectoDAO.findAll();

        if(!estados.isEmpty())
        {
            id = estados.get(estados.size() - 1).getId() + 1L;
        }

        return id;
    }

    private Long obtenerTipoConsultoriaID()
    {
        var id = 1L;
        var tiposConsultoria = this.tipoConsultoriaProyectoDAO.findAll();

        if(!tiposConsultoria.isEmpty())
        {
            id = tiposConsultoria.get(tiposConsultoria.size() - 1).getId() + 1L;
        }

        return id;
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