package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultarProyectosManejador
{
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ConsultarProyectosManejador(NecesidadRepositorioConsulta necesidadRepositorioConsulta)
    {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }
    @Transactional
    public List<ProyectoDTO> ejecutar()
    {
        return this.necesidadRepositorioConsulta.consultarProyectos();
    }
}