package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioEliminarAsociacionPorAdministrador {
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioEliminarAsociacionPorAdministrador(AsociacionRepositorioConsulta asociacionRepositorioConsulta, AsociacionRepositorioComando asociacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.asociacionRepositorioComando = asociacionRepositorioComando;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(Long id) throws MessagingException {
        validarSiExisteAsociacionConID(id);

        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(id);
        var correo = this.personaRepositorioConsulta.consultarPorId(asociacion.getUsuarioId()).getCorreo();
        var asunto = Mensajes.ASOCIACION_DE_TU_CUENTA_DE_ARQUISWQ_ELIMINADA_ASUNTO;
        var cuerpo = Mensajes.LA_ASOCIACION_O_EMPRESA + asociacion.getNombre() + Mensajes.CON_EL_NIT + asociacion.getNit() + Mensajes.HA_SIDO_ELIMINADA_POR_EL_ADMINISTRADOR;

        this.personaRepositorioComando.eliminarRolAsociacion(Rol.crear(TextoConstante.ROL_ASOCIACION), id);
        this.asociacionRepositorioComando.eliminarPorAdministrador(id);
        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);

        return id;
    }

    private void validarSiExisteAsociacionConID(Long id) {
        if (ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id);
        }
    }
}