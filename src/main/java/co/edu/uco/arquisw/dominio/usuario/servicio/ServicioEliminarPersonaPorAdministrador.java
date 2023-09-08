package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioEliminarPersonaPorAdministrador {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;

    public ServicioEliminarPersonaPorAdministrador(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(Long id) throws MessagingException {
        validarSiNoExisteUsuarioConId(id);

        var correo = this.personaRepositorioConsulta.consultarPorId(id).getCorreo();
        var asunto = TextoConstante.CUENTA_DE_ARQUISQ_ELIMINADA_ASUNTO;
        var cuerpo = TextoConstante.TU_CUENTA_HA_SIDO_ELIMINADA_DE_FORMA_DEFINITIVA_POR_EL_ADMINISTRADOR;

        this.personaRepositorioComando.eliminarPorAdminsitrador(id);
        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return id;
    }

    private void validarSiNoExisteUsuarioConId(Long id) {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}