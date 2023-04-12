package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.contrato.modelo.Contrato;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.FaseRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioGuardarContrato {
    private final ContratoRepositorioComando contratoRepositorioComando;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final FaseRepositorioComando faseRepositorioComando;

    public ServicioGuardarContrato(ContratoRepositorioComando contratoRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, FaseRepositorioComando faseRepositorioComando) {
        this.contratoRepositorioComando = contratoRepositorioComando;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.faseRepositorioComando = faseRepositorioComando;
    }

    public Long ejecutar(Contrato contrato, Long necesidadID) {
        validarSiExisteNecesidadConId(necesidadID);

        var proyectoID = obtenerProyectoID(necesidadID);

        this.necesidadRepositorioComando.actualizarEstadoNecesidad(EstadoNecesidad.crear(TextoConstante.ESTADO_NEGOCIADO), necesidadID);

        this.faseRepositorioComando.guardar(proyectoID);

        this.necesidadRepositorioComando.actualizarEstadoProyecto(EstadoProyecto.crear(TextoConstante.ESTADO_EN_DESARROLLO), proyectoID);

        return this.contratoRepositorioComando.guardar(contrato, necesidadID);
    }

    private void validarSiExisteNecesidadConId(Long necesidadID) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorId(necesidadID))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + necesidadID);
        }
    }

    private Long obtenerProyectoID(Long necesidadID) {
        var necesidadDTO = this.necesidadRepositorioConsulta.consultarPorId(necesidadID);

        return necesidadDTO.getProyecto().getId();
    }
}