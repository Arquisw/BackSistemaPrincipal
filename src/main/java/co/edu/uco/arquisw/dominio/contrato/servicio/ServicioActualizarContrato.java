package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.modelo.Contrato;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioActualizarContrato {
    private final ContratoRepositorioComando contratoRepositorioComando;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;

    public ServicioActualizarContrato(ContratoRepositorioComando contratoRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.contratoRepositorioComando = contratoRepositorioComando;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(Contrato contrato, Long necesidadId) throws MessagingException {
        validarSiExisteAsociacionConId(necesidadId);

        var necesidad = this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadId);
        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(necesidad.getAsociacion());
        var correo = this.personaRepositorioConsulta.consultarPorId(asociacion.getUsuarioId()).getCorreo();
        var asunto = TextoConstante.CONTRATO_DEL_PROYECTO_ACTUAL_ACTUALIZADO;
        var cuerpo = TextoConstante.EL_CONTRATO_DEL_PROYECTO + necesidad.getProyecto().getNombre() +  TextoConstante.HA_SIDO_ACTUALIZADO_POR_EL_ADMINISTRADOR;

        var respuestaId = this.contratoRepositorioComando.actualizar(contrato, necesidadId);
        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return respuestaId;
    }

    private void validarSiExisteAsociacionConId(Long necesidadId) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadId))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + necesidadId);
        }
    }
}