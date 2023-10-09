package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarNecesidadPorId {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioConsultarNecesidadPorId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public NecesidadDTO ejecutar(Long id) {
        validarSiExisteNecesidadConID(id);

        return this.necesidadRepositorioConsulta.consultarPorNecesidadId(id);
    }

    private void validarSiExisteNecesidadConID(Long id) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteNecesidadConId(id));
        }
    }
}