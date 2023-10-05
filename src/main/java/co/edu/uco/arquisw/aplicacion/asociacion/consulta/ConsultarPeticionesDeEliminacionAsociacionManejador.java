package co.edu.uco.arquisw.aplicacion.asociacion.consulta;

import co.edu.uco.arquisw.dominio.asociacion.dto.PeticionEliminacionAsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultarPeticionesDeEliminacionAsociacionManejador {
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    public ConsultarPeticionesDeEliminacionAsociacionManejador(AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }

    @Transactional
    public Page<PeticionEliminacionAsociacionDTO> ejecutar(int pagina, int tamano) {
        return asociacionRepositorioConsulta.consultarPeticionesDeEliminacionDeAsociaciones(pagina,tamano);
    }
}