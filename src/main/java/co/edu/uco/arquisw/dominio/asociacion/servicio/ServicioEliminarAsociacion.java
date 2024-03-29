package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import static co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.enumerador.TipoNotificacion.ASOCIACION_ELIMINADA;

public class ServicioEliminarAsociacion {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioActualizarToken servicioActualizarToken;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;

    public ServicioEliminarAsociacion(PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioActualizarToken servicioActualizarToken, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.asociacionRepositorioComando = asociacionRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioActualizarToken = servicioActualizarToken;
        this.servicioNotificacionFactoria = servicioNotificacionFactoria;
    }

    public Long ejecutar(Long id) {
        validarSiExisteUsuarioConID(id);
        validarSiPuedeEliminarLaCuenta(id);

        var rol = Rol.crear(TextoConstante.ROL_ASOCIACION);
        var correo = this.personaRepositorioConsulta.consultarPorId(id).getCorreo();

        this.personaRepositorioComando.eliminarRolAsociacion(rol, id);
        this.asociacionRepositorioComando.eliminar(id);

        this.servicioNotificacionFactoria.orquestarNotificacion(
                ASOCIACION_ELIMINADA,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                id,
                NumeroConstante.CERO,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                correo,
                new SeleccionDTO()
        );

        servicioActualizarToken.ejecutar();

        return id;
    }

    private void validarSiPuedeEliminarLaCuenta(Long id) {
        if (!ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorIDUsuario(id))) {
            var asociacion = this.asociacionRepositorioConsulta.consultarPorIDUsuario(id);

            this.asociacionRepositorioComando.crearNotificacionEliminacion(asociacion.getId());

            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_REGISTRADA);
        }
    }

    private void validarSiExisteUsuarioConID(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteUsuarioConId(id));
        }
    }
}