package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultarProyectosAprobadosManejador {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ConsultarProyectosAprobadosManejador(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    @Transactional
    public List<NecesidadDTO> ejecutar() {
        return this.necesidadRepositorioConsulta.consultarProyectosAprobados();
    }
}