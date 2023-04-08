package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;

public class ServicioSeleccionarUsuario {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;

    public ServicioSeleccionarUsuario(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.postulacionRepositorioComando = postulacionRepositorioComando;
        this.personaRepositorioComando = personaRepositorioComando;
    }

    public Long ejecutar(Long id) {
        validarSiExistePostulacionConId(id);

        var postulacionDTO = postulacionRepositorioConsulta.consultarPostulacionPorId(id);
        var seleccion = Seleccion.crear(postulacionDTO.getRol());

        this.personaRepositorioComando.eliminarRol(Rol.crear(TextoConstante.ROL_POSTULADO), postulacionDTO.getUsuarioID());
        this.personaRepositorioComando.crearRol(Rol.crear(TextoConstante.ROL_SELECCIONADO), postulacionDTO.getUsuarioID());
        this.personaRepositorioComando.crearRol(Rol.crear(postulacionDTO.getRol()), postulacionDTO.getUsuarioID());

        return this.postulacionRepositorioComando.seleccionarUsuario(seleccion, id);
    }

    private void validarSiExistePostulacionConId(Long id) {
        if(ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id);
        }
    }
}