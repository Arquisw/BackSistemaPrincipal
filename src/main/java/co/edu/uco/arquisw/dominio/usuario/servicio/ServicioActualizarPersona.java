package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.DuplicidadExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioActualizarPersona {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioActualizarPersona(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(Persona persona, Long id) {
        validarSiNoExisteUsuario(id);
        validarSiExisteUsuarioConCorreo(persona);

        return this.personaRepositorioComando.actualizar(persona, id);
    }

    private void validarSiNoExisteUsuario(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteUsuarioConId(id));
        }
    }

    private void validarSiExisteUsuarioConCorreo(Persona persona) {
        if (this.personaRepositorioConsulta.existeConCorreo(persona.getCorreo())) {
            throw new DuplicidadExcepcion(Mensajes.EXISTE_USUARIO_CON_CORREO);
        }
    }
}