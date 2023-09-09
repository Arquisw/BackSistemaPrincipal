package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.contrato.dto.ContratoDTO;
import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarContratoPorId {
    private final ContratoRepositorioConsulta contratoRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioConsultarContratoPorId(ContratoRepositorioConsulta contratoRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.contratoRepositorioConsulta = contratoRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public ContratoDTO ejecutar(Long necesidadID) {
        validarSiExisteNecesidadConId(necesidadID);

        return this.contratoRepositorioConsulta.consultarPorId(necesidadID);
    }

    private void validarSiExisteNecesidadConId(Long necesidadID) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadID))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + necesidadID);
        }
    }
}