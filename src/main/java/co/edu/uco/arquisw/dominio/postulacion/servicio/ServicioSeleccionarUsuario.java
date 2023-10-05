package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
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
import java.util.List;

import static co.edu.uco.arquisw.dominio.transversal.enumerator.TipoNotificacion.USUARIO_SELECCIONADO;

@AllArgsConstructor
public class ServicioSeleccionarUsuario {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioActualizarToken servicioActualizarToken;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;

    public Long ejecutar(List<String> roles, Long id) {
        validarSiExistePostulacionConId(id);

        var postulacionDTO = this.postulacionRepositorioConsulta.consultarPostulacionPorId(id);
        postulacionDTO.setRoles(roles);
        var seleccion = Seleccion.crear(postulacionDTO.getRoles());
        var postulacion = Postulacion.crear(postulacionDTO.getRoles(), true, false);

        var correo = this.personaRepositorioConsulta.consultarPorId(postulacionDTO.getUsuarioID()).getCorreo();

        this.personaRepositorioComando.eliminarRol(Rol.crear(TextoConstante.ROL_POSTULADO), postulacionDTO.getUsuarioID());
        this.personaRepositorioComando.crearRol(Rol.crear(TextoConstante.ROL_SELECCIONADO), postulacionDTO.getUsuarioID());
        postulacionDTO.getRoles().forEach(rol -> this.personaRepositorioComando.crearRol(Rol.crear(rol), postulacionDTO.getUsuarioID()));
        this.postulacionRepositorioComando.actualizar(postulacion, postulacionDTO.getProyectoID(), postulacionDTO.getUsuarioID(), id);
        servicioActualizarToken.ejecutar();
        var respuestaId =  this.postulacionRepositorioComando.seleccionarUsuario(seleccion, id);

        this.servicioNotificacionFactoria.orquestarNotificacion(
                USUARIO_SELECCIONADO,
                postulacionDTO.getProyectoID(),
                NumeroConstante.Zero,
                NumeroConstante.Zero,
                NumeroConstante.Zero,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                correo,
                new SeleccionDTO()
        );

        return respuestaId;
    }

    private void validarSiExistePostulacionConId(Long id) {
        if (ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id);
        }
    }
}