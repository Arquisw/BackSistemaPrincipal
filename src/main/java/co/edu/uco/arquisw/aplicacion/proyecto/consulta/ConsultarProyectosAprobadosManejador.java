package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import org.springframework.data.domain.Page;
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
    public Page<NecesidadDTO> ejecutar(int pagina, int tamano) {
        return this.necesidadRepositorioConsulta.consultarProyectosAprobadosPaginado(pagina,tamano);
    }
}