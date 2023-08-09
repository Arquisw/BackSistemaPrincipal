package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;

public class ServicioEliminarAsociacionPorAdministrador {
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;

    public ServicioEliminarAsociacionPorAdministrador(AsociacionRepositorioConsulta asociacionRepositorioConsulta, AsociacionRepositorioComando asociacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando) {
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.asociacionRepositorioComando = asociacionRepositorioComando;
        this.personaRepositorioComando = personaRepositorioComando;
    }

    public Long ejecutar(Long id) {
        validarSiExisteAsociacionConID(id);

        this.personaRepositorioComando.eliminarRolAsociacion(Rol.crear(TextoConstante.ROL_ASOCIACION), id);

        this.asociacionRepositorioComando.eliminar(id);

        return id;
    }

    private void validarSiExisteAsociacionConID(Long id) {
        if(ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorIDUsuario(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id);
        }
    }
}