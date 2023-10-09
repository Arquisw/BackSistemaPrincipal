package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioActualizarPostulacion {
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioActualizarPostulacion(PostulacionRepositorioComando postulacionRepositorioComando, PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.postulacionRepositorioComando = postulacionRepositorioComando;
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public Long ejecutar(Postulacion postulacion, Long proyectoId, Long usuarioId, Long id) {
        validarSiExistePostulacionConId(id);
        validarSiExisteProyectoConId(proyectoId);
        validarSiExisteUsuarioConId(usuarioId);

        return this.postulacionRepositorioComando.actualizar(postulacion, proyectoId, usuarioId, id);
    }

    private void validarSiExistePostulacionConId(Long id) {
        if (ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExistePostulacionConId(id));
        }
    }

    private void validarSiExisteProyectoConId(Long id) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteProyectoConId(id));
        }
    }

    private void validarSiExisteUsuarioConId(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteUsuarioConId(id));
        }
    }
}