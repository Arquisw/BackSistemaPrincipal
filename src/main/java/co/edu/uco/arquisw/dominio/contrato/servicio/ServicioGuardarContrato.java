package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.modelo.Contrato;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioGuardarContrato {
    private final ContratoRepositorioComando contratoRepositorioComando;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;

    public ServicioGuardarContrato(ContratoRepositorioComando contratoRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.contratoRepositorioComando = contratoRepositorioComando;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(Contrato contrato, Long necesidadID) throws MessagingException {
        validarSiExisteNecesidadConId(necesidadID);

        var necesidad = this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadID);
        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(necesidad.getAsociacion());
        var correo = this.personaRepositorioConsulta.consultarPorId(asociacion.getUsuarioId()).getCorreo();
        var asunto = TextoConstante.CONTRATO_DEL_PROYECTO_ACTUAL_EFECTUADO;
        var cuerpo = TextoConstante.EL_CONTRATO_DEL_PROYECTO + necesidad.getProyecto().getNombre() +  TextoConstante.HA_SIDO_EFECTUADO_Y_GUARDADO_EN_LA_PLATAFORMA_POR_EL_ADMINISTRADOR;

        this.necesidadRepositorioComando.actualizarEstadoNecesidad(EstadoNecesidad.crear(TextoConstante.ESTADO_NEGOCIADO), necesidadID);
        var respuestaId = this.contratoRepositorioComando.guardar(contrato, necesidadID);
        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return respuestaId;
    }

    private void validarSiExisteNecesidadConId(Long necesidadID) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadID))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + necesidadID);
        }
    }
}