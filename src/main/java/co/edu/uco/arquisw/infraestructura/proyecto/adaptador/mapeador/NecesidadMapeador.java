package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.NecesidadEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NecesidadMapeador
{
    @Autowired
    EstadoNecesidadMapeador estadoNecesidadMapeador;
    @Autowired
    ProyectoMapeador proyectoMapeador;

    public NecesidadDTO construirDTO(NecesidadEntidad necesidad)
    {
        return new NecesidadDTO(necesidad.getId(), necesidad.getRutaArchivo(), this.estadoNecesidadMapeador.construirDTO(necesidad.getEstado()), this.proyectoMapeador.construirDTO(necesidad.getProyecto()));
    }

    public List<NecesidadDTO> construirDTOs(List<NecesidadEntidad> necesidades)
    {
        return necesidades.stream().map(new NecesidadMapeador()::construirDTO).toList();
    }

    public NecesidadEntidad construirEntidad(Necesidad necesidad, Long asociacionID)
    {
        return new NecesidadEntidad(0L, necesidad.getRutaArchivo(), this.estadoNecesidadMapeador.construirEntidad(necesidad.getEstado()), this.proyectoMapeador.construirEntidad(necesidad.getProyecto()), asociacionID);
    }
}