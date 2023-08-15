package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultarProyectosNegociadosManejador {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ConsultarProyectosNegociadosManejador(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    @Transactional
    public List<NecesidadDTO> ejecutar() {
        return this.necesidadRepositorioConsulta.consultarProyectosNegociados();
    }
}