package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioConsultarHojaDeVidaPorIdUsuario {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioConsultarHojaDeVidaPorIdUsuario(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public HojaDeVidaPersonaDTO ejecutar(Long id) {
        validarSiNoExisteUsuarioConId(id);

        return personaRepositorioConsulta.consultarHojaDeVidaPorIdUsuario(id);
    }

    private void validarSiNoExisteUsuarioConId(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}