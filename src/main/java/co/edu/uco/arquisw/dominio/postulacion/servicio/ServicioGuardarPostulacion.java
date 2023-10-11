package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioGuardarPostulacion {
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final ServicioActualizarToken servicioActualizarToken;

    public ServicioGuardarPostulacion(PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioActualizarToken servicioActualizarToken) {
        this.postulacionRepositorioComando = postulacionRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.personaRepositorioComando = personaRepositorioComando;
        this.servicioActualizarToken = servicioActualizarToken;
    }

    public Long ejecutar(Postulacion postulacion, Long proyectoID, Long usuarioID) {
        validarSiExisteProyectoConId(proyectoID);
        validarSiExistePersonaConId(usuarioID);
        validarSiUsuarioConIDEstaActivo(usuarioID);

        this.personaRepositorioComando.crearRol(Rol.crear(TextoConstante.ROL_POSTULADO), usuarioID);
        this.servicioActualizarToken.ejecutar();
        return this.postulacionRepositorioComando.guardar(postulacion, proyectoID, usuarioID);
    }

    private void validarSiExisteProyectoConId(Long proyectoID) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(proyectoID))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteProyectoConId(proyectoID));
        }
    }

    private void validarSiExistePersonaConId(Long usuarioID) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(usuarioID))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteUsuarioConId(usuarioID));
        }
    }

    private void validarSiUsuarioConIDEstaActivo(Long usuarioID) {
        var persona = this.personaRepositorioConsulta.consultarPorId(usuarioID);
        var usuario = this.personaRepositorioConsulta.consultarUsuarioPorCorreo(persona.getCorreo());

        if (!usuario.isActivado()) {
            throw new AutorizacionExcepcion(Mensajes.PARA_POSTULARSE_A_UN_PROYECTO_DEBES_ACTIVAR_TU_CUENTA);
        }
    }
}