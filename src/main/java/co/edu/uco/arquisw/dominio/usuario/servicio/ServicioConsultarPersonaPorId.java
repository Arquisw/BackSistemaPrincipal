package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioConsultarPersonaPorId {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioConsultarPersonaPorId(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public PersonaDTO ejecutar(Long id) {
        validarSiNoExisteUsuarioConId(id);

        return personaRepositorioConsulta.consultarPorId(id);
    }

    private void validarSiNoExisteUsuarioConId(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteUsuarioConId(id));
        }
    }
}