package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import static co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.enumerador.TipoNotificacion.PERSONA_ELIMINADA;

public class ServicioEliminarPersona {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;

    public ServicioEliminarPersona(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PostulacionRepositorioConsulta postulacionRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.servicioNotificacionFactoria = servicioNotificacionFactoria;
    }

    public Long ejecutar(Long id) {
        validarSiNoExisteUsuarioConId(id);
        validarSiPuedeEliminarLaCuenta(id);

        var correo = this.personaRepositorioConsulta.consultarPorId(id).getCorreo();

        this.personaRepositorioComando.eliminar(id);

        this.servicioNotificacionFactoria.orquestarNotificacion(
                PERSONA_ELIMINADA,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                correo,
                new SeleccionDTO()
        );

        return id;
    }

    private void validarSiNoExisteUsuarioConId(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteUsuarioConId(id));
        }
    }

    private void validarSiPuedeEliminarLaCuenta(Long id) {
        if (!ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorIDUsuario(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_ASOCIACION_A_CARGO);
        }

        if (!ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarSeleccionesPorUsuarioId(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_SELECCIONADO_EN_UN_PROYECTO);
        }

        if (!ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionesPorUsuarioId(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_EN_UN_PROCESO_DE_POSTULACION);
        }

    }
}