package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import lombok.AllArgsConstructor;

import static co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.enumerador.TipoNotificacion.ASOCIACION_ELIMINADA_POR_ADMINISTRADOR;

@AllArgsConstructor
public class ServicioEliminarAsociacionPorAdministrador {
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public Long ejecutar(Long id) {
        validarSiExisteAsociacionConID(id);

        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(id);
        var correo = this.personaRepositorioConsulta.consultarPorId(asociacion.getUsuarioId()).getCorreo();

        this.personaRepositorioComando.eliminarRolAsociacion(Rol.crear(TextoConstante.ROL_ASOCIACION), id);
        this.asociacionRepositorioComando.eliminarPorAdministrador(id);

        this.servicioNotificacionFactoria.orquestarNotificacion(
                ASOCIACION_ELIMINADA_POR_ADMINISTRADOR,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                id,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                correo,
                new SeleccionDTO()
        );

        return id;
    }

    private void validarSiExisteAsociacionConID(Long id) {
        if (ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteAsociacionConId(id));
        }
    }
}