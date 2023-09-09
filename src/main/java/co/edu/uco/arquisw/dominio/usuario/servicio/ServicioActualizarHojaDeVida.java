package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioActualizarHojaDeVida {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioActualizarHojaDeVida(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(HojaDeVidaPersona hojaDeVida, Long usuarioId) {
        validarSiExisteUsuarioConID(usuarioId);
        validarSiExisteHojaDeVida(usuarioId);

        return this.personaRepositorioComando.actualizarHojaDeVida(hojaDeVida, usuarioId);
    }

    private void validarSiExisteUsuarioConID(Long usuarioId) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(usuarioId))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + usuarioId);
        }
    }

    private void validarSiExisteHojaDeVida(Long usuarioId) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarHojaDeVidaPorIdUsuario(usuarioId))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_HOJA_DE_VIDA_CON_EL_ID + usuarioId);
        }
    }
}