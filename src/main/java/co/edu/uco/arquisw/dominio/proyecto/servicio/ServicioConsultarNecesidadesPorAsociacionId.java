package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

import java.util.List;

public class ServicioConsultarNecesidadesPorAsociacionId {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    public ServicioConsultarNecesidadesPorAsociacionId(NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }

    public List<NecesidadDTO> ejecutar(Long id) {
        validarSiExisteAsociacionConID(id);

        return this.necesidadRepositorioConsulta.consultarNecesidadesPorId(id);
    }

    private void validarSiExisteAsociacionConID(Long id) {
        if (ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id);
        }
    }
}