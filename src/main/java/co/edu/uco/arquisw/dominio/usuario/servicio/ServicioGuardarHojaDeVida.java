package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioGuardarHojaDeVida {

    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;


    public ServicioGuardarHojaDeVida(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(HojaDeVidaPersona hojaDeVida, Long usuarioId)
    {
        validarSiExisteUsuarioConID(usuarioId);

        return this.personaRepositorioComando.guardarHojaDeVida(hojaDeVida, usuarioId);
    }
    private void validarSiExisteUsuarioConID(Long usuarioId)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(usuarioId)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + usuarioId);
        }
    }
}
