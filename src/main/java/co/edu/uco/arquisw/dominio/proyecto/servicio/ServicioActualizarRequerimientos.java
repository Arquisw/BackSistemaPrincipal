package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.modelo.Requerimientos;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioActualizarRequerimientos {
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioActualizarRequerimientos(NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public Long ejecutar(Requerimientos requerimientos, Long necesidadId) {
        validarSiExisteNecesidadConId(necesidadId);

        return this.necesidadRepositorioComando.actualizarRequerimientos(requerimientos, necesidadId);
    }

    private void validarSiExisteNecesidadConId(Long necesidadId) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadId))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteNecesidadConId(necesidadId));
        }
    }
}