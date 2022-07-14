package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador.PostulacionMapeador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador.SeleccionMapeador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.PostulacionDAO;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.SeleccionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PostulacionRepositorioConsultaImplementacion implements PostulacionRepositorioConsulta
{
    @Autowired
    PostulacionMapeador postulacionMapeador;
    @Autowired
    SeleccionMapeador seleccionMapeador;
    @Autowired
    PostulacionDAO postulacionDAO;
    @Autowired
    SeleccionDAO seleccionDAO;
    @Override
    public PostulacionDTO consultarPostulacionPorId(Long id)
    {
        var entidad = this.postulacionDAO.findById(id).orElse(null);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.postulacionMapeador.construirDTO(entidad);
    }

    @Override
    public PostulacionDTO consultarPostulacionPorUsuarioId(Long id)
    {
        var entidad = this.postulacionDAO.findByUsuario(id);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.postulacionMapeador.construirDTO(entidad);
    }

    @Override
    public List<PostulacionDTO> consultarPostulacionesPorProyecto(Long proyectoID)
    {
        var entidades = this.postulacionDAO.findAll();

        var postulaciones = entidades.stream().filter(entidad -> entidad.getId().equals(proyectoID)).toList();

        return this.postulacionMapeador.construirDTOs(postulaciones);
    }

    @Override
    public SeleccionDTO consultarSeleccionPorId(Long id)
    {
        var entidad = this.seleccionDAO.findById(id).orElse(null);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.seleccionMapeador.construirDTO(entidad);
    }

    @Override
    public SeleccionDTO consultarSeleccionPorUsuarioId(Long id)
    {
        var entidad = this.seleccionDAO.findByUsuario(id);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.seleccionMapeador.construirDTO(entidad);
    }

    @Override
    public List<SeleccionDTO> consultarSeleccionadosPorProyecto(Long proyectoID)
    {
        var entidades = this.seleccionDAO.findAll();

        var selecciones = entidades.stream().filter(entidad -> entidad.getId().equals(proyectoID)).toList();

        return this.seleccionMapeador.construirDTOs(selecciones);
    }
}