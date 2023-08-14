package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.MotivoRechazoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioRechazarProyecto {
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioRechazarProyecto(NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public Long ejecutar(MotivoRechazoNecesidad motivoRechazoNecesidad, Long id) {
        validarSiExisteNecesidadConID(id);

        this.necesidadRepositorioComando.actualizarEstadoNecesidad(EstadoNecesidad.crear(TextoConstante.ESTADO_RECHAZADO), id);

        return this.necesidadRepositorioComando.guardarMotivoRechazoNecesidad(motivoRechazoNecesidad, id);
    }

    private void validarSiExisteNecesidadConID(Long id) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + id);
        }
    }
}
