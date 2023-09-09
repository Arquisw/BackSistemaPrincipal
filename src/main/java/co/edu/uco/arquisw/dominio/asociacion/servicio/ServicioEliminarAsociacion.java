package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioEliminarAsociacion {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioActualizarToken servicioActualizarToken;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;

    public ServicioEliminarAsociacion(PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioActualizarToken servicioActualizarToken, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.asociacionRepositorioComando = asociacionRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioActualizarToken = servicioActualizarToken;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(Long id) throws MessagingException {
        validarSiExisteUsuarioConID(id);
        validarSiPuedeEliminarLaCuenta(id);

        var rol = Rol.crear(TextoConstante.ROL_ASOCIACION);
        var correo = this.personaRepositorioConsulta.consultarPorId(id).getCorreo();
        var asociacion = this.asociacionRepositorioConsulta.consultarPorIDUsuario(id);
        var asunto = Mensajes.ASOCIACION_DE_TU_CUENTA_DE_ARQUISWQ_ELIMINADA_ASUNTO;
        var cuerpo = Mensajes.LA_ASOCIACION_O_EMPRESA + asociacion.getNombre() + Mensajes.CON_EL_NIT + asociacion.getNit() + Mensajes.HA_SIDO_ELIMINADA_POR_TI;

        this.personaRepositorioComando.eliminarRolAsociacion(rol, id);
        this.asociacionRepositorioComando.eliminar(id);
        this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);
        servicioActualizarToken.ejecutar();

        return id;
    }

    private void validarSiPuedeEliminarLaCuenta(Long id) {
        var asociacion = this.asociacionRepositorioConsulta.consultarPorIDUsuario(id);

        if (!ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorAsociacionId(asociacion.getId()))) {
            this.asociacionRepositorioComando.crearNotificacionEliminacion(asociacion.getId());
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_REGISTRADA);
        }
    }

    private void validarSiExisteUsuarioConID(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}