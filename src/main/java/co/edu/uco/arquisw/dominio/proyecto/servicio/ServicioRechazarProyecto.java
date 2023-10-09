package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.MotivoRechazoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import lombok.AllArgsConstructor;

import static co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.enumerador.TipoNotificacion.PROYECTO_RECHAZADO;

@AllArgsConstructor
public class ServicioRechazarProyecto {
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;

    public Long ejecutar(MotivoRechazoNecesidad motivoRechazoNecesidad, Long id) {
        validarSiExisteNecesidadConID(id);

        var necesidad = this.necesidadRepositorioConsulta.consultarPorNecesidadId(id);
        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(necesidad.getAsociacion());
        var correo = this.personaRepositorioConsulta.consultarPorId(asociacion.getUsuarioId()).getCorreo();

        this.necesidadRepositorioComando.actualizarEstadoNecesidad(EstadoNecesidad.crear(TextoConstante.ESTADO_RECHAZADO), id);
        var motivoRechazoId = this.necesidadRepositorioComando.guardarMotivoRechazoNecesidad(motivoRechazoNecesidad, id);

        this.servicioNotificacionFactoria.orquestarNotificacion(
                PROYECTO_RECHAZADO,
                NumeroConstante.CERO,
                id,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                TextoConstante.VACIO,
                motivoRechazoNecesidad.getMotivo(),
                correo,
                new SeleccionDTO()
        );

        return motivoRechazoId;
    }

    private void validarSiExisteNecesidadConID(Long id) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteNecesidadConId(id));
        }
    }
}