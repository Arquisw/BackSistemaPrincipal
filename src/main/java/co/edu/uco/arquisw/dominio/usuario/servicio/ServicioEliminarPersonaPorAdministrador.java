package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import static co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.enumerador.TipoNotificacion.PERSONA_ELIMINADA_POR_ADMINISTRADOR;

public class ServicioEliminarPersonaPorAdministrador {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;

    public ServicioEliminarPersonaPorAdministrador(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioNotificacionFactoria = servicioNotificacionFactoria;
    }

    public Long ejecutar(Long id) {
        validarSiNoExisteUsuarioConId(id);

        var correo = this.personaRepositorioConsulta.consultarPorId(id).getCorreo();

        this.personaRepositorioComando.eliminarPorAdminsitrador(id);

        this.servicioNotificacionFactoria.orquestarNotificacion(
                PERSONA_ELIMINADA_POR_ADMINISTRADOR,
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
}