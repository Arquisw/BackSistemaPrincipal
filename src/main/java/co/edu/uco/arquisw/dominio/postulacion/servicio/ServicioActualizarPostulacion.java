package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;

public class ServicioActualizarPostulacion {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;

    public ServicioActualizarPostulacion(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando)
    {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.postulacionRepositorioComando = postulacionRepositorioComando;
        this.personaRepositorioComando = personaRepositorioComando;
    }

    public Long ejecutar(Postulacion postulacion, Long id)
    {
        validarSiExistePostulacionConId(id);

        postulacion.seleccionarPostulante();

        Seleccion seleccion = Seleccion.crear(postulacion.getRol());

        var rol = Rol.crear(postulacion.getRol());
        var rolSeleccionado = Rol.crear(TextoConstante.ROL_SELECCIONADO);
        var rolPostulado = Rol.crear(TextoConstante.ROL_POSTULADO);

        var postulacionDTO = this.postulacionRepositorioConsulta.consultarPostulacionPorId(id);

        this.personaRepositorioComando.eliminarRol(rolPostulado, postulacionDTO.getUsuarioID());
        this.personaRepositorioComando.actualizarRol(rolSeleccionado, postulacionDTO.getUsuarioID());
        this.personaRepositorioComando.actualizarRol(rol, postulacionDTO.getUsuarioID());

        return this.postulacionRepositorioComando.actualizar(postulacion, seleccion, id);
    }
    private void validarSiExistePostulacionConId(Long id)
    {
        if(ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorId(id)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id);
        }
    }
}
