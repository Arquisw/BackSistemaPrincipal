package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.dto.RequerimientosDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarRequerimientosPorNecesidadId {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioConsultarRequerimientosPorNecesidadId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public RequerimientosDTO ejecutar(Long necesidadId) {
        validarSiExisteNecesidadConId(necesidadId);

        return this.necesidadRepositorioConsulta.consultarRequerimientoPorNecesidadId(necesidadId);
    }

    private void validarSiExisteNecesidadConId(Long necesidadId) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadId))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + necesidadId);
        }
    }
}
