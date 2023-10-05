package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import lombok.AllArgsConstructor;

import javax.mail.MessagingException;

import java.util.ArrayList;

import static co.edu.uco.arquisw.dominio.transversal.enumerator.TipoNotificacion.PROYECTO_APROBADO;

@AllArgsConstructor
public class ServicioAprobarProyecto {
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;

    public Long ejecutar(Long id) {
        validarSiExisteNecesidadConID(id);

        var necesidad = this.necesidadRepositorioConsulta.consultarPorNecesidadId(id);
        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(necesidad.getAsociacion());
        var correo = this.personaRepositorioConsulta.consultarPorId(asociacion.getUsuarioId()).getCorreo();

        var respuestaId = this.necesidadRepositorioComando.actualizarEstadoNecesidad(EstadoNecesidad.crear(TextoConstante.ESTADO_APROBADO), id);

        this.servicioNotificacionFactoria.orquestarNotificacion(
                PROYECTO_APROBADO,
                NumeroConstante.Zero,
                id,
                NumeroConstante.Zero,
                NumeroConstante.Zero,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                correo,
                new SeleccionDTO()
        );

        return respuestaId;
    }

    private void validarSiExisteNecesidadConID(Long id) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + id);
        }
    }
}