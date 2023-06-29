package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class  ServicioLogin {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioLogin(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(String correo) {
        validarSiNoExisteUsuarioConCorreo(correo);

        return personaRepositorioConsulta.consultarPorCorreo(correo).getId();
    }

    private void validarSiNoExisteUsuarioConCorreo(String correo) {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorCorreo(correo))) {
            throw new AutorizacionExcepcion(Mensajes.USUARIO_O_CLAVE_INCORRECTAS);
        }
    }
}