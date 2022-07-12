package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultarNecesidadesManejador
{
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ConsultarNecesidadesManejador(NecesidadRepositorioConsulta necesidadRepositorioConsulta)
    {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public List<NecesidadDTO> ejecutar()
    {
        return this.necesidadRepositorioConsulta.consultarNecesidades();
    }
}