package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.ProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.NecesidadMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador.ProyectoMapeador;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NecesidadRepositorioConsultaImplementacion implements NecesidadRepositorioConsulta
{
    @Autowired
    NecesidadMapeador necesidadMapeador;
    @Autowired
    ProyectoMapeador proyectoMapeador;
    @Autowired
    ProyectoDAO proyectoDAO;
    @Autowired
    NecesidadDAO necesidadDAO;

    @Override
    public NecesidadDTO consultarPorId(Long id)
    {
        var entidad = this.necesidadDAO.findByAsociacion(id);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.necesidadMapeador.construirDTO(entidad);
    }

    @Override
    public List<NecesidadDTO> consultarNecesidades()
    {
        var entidades = this.necesidadDAO.findAll();

        var necesidades = entidades.stream().filter(entidad -> entidad.getEstado().getEstado().getNombre().equals(TextoConstante.ESTADO_EN_ESPERA)).toList();

        return this.necesidadMapeador.construirDTOs(necesidades);
    }

    @Override
    public ProyectoDTO consultarProyectoPorId(Long proyectoID)
    {
        var entidad = this.proyectoDAO.findById(proyectoID).orElse(null);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.proyectoMapeador.construirDTO(entidad);
    }

    @Override
    public List<ProyectoDTO> consultarProyectos()
    {
        var entidades = this.necesidadDAO.findAll();

        var necesidades = entidades.stream().filter(entidad -> entidad.getEstado().getEstado().getNombre().equals(TextoConstante.ESTADO_APROBADO)).toList();

        List<ProyectoEntidad> proyectos = new ArrayList<>();

        necesidades.forEach(necesidad -> proyectos.add(necesidad.getProyecto()));

        return this.proyectoMapeador.construirDTOs(proyectos);
    }
}