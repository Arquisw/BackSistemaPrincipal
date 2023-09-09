package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.dominio.proyecto.dto.PeticionEliminacionNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultarPeticionesDeEliminacionNecesidadManejador {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ConsultarPeticionesDeEliminacionNecesidadManejador(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    @Transactional
    public List<PeticionEliminacionNecesidadDTO> ejecutar() {
        return necesidadRepositorioConsulta.consultarPeticionesDeEliminacionDeNecesidades();
    }
}