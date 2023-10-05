package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.MotivoRechazoPostulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import lombok.AllArgsConstructor;

import javax.mail.MessagingException;

import java.util.ArrayList;

import static co.edu.uco.arquisw.dominio.transversal.enumerator.TipoNotificacion.USUARIO_RECHAZADO;

@AllArgsConstructor
public class ServicioRechazarUsuario {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;


    public Long ejecutar(MotivoRechazoPostulacion motivoRechazoPostulacion, Long id) {
        validarSiExistePostulacionConId(id);

        var postulacionDTO = postulacionRepositorioConsulta.consultarPostulacionPorId(id);
        var postulacion = Postulacion.crear(postulacionDTO.getRoles(), false, true);
        var correo = this.personaRepositorioConsulta.consultarPorId(postulacionDTO.getUsuarioID()).getCorreo();

        this.personaRepositorioComando.eliminarRol(Rol.crear(TextoConstante.ROL_POSTULADO), postulacionDTO.getUsuarioID());
        this.postulacionRepositorioComando.actualizar(postulacion, postulacionDTO.getProyectoID(), postulacionDTO.getUsuarioID(), id);
        var respuestId = this.postulacionRepositorioComando.rechazarUsuario(motivoRechazoPostulacion, id);

        this.servicioNotificacionFactoria.orquestarNotificacion(
                USUARIO_RECHAZADO,
                postulacionDTO.getProyectoID(),
                NumeroConstante.Zero,
                NumeroConstante.Zero,
                NumeroConstante.Zero,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                correo,
                new SeleccionDTO()
        );

        return respuestId;
    }

    private void validarSiExistePostulacionConId(Long id) {
        if (ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id);
        }
    }
}