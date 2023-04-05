package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioEliminarPersona {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;

    public ServicioEliminarPersona(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PostulacionRepositorioConsulta postulacionRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
    }

    public Long ejecutar(Long id) {
        validarSiNoExisteUsuarioConId(id);
        validarSiPuedeEliminarLaCuenta(id);

        this.personaRepositorioComando.eliminar(id);

        return id;
    }

    private void validarSiPuedeEliminarLaCuenta(Long id) {
        if(!ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_ASOCIACION_A_CARGO);
        }

        if(!ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarSeleccionPorUsuarioId(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_SELECCIONADO_EN_UN_PROYECTO);
        }

        if(!ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorUsuarioId(id))) {
            this.personaRepositorioComando.crearNotificacionEliminacion(id);
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_EN_UN_PROCESO_DE_POSTULACION);
        }

    }

    private void validarSiNoExisteUsuarioConId(Long id) {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}