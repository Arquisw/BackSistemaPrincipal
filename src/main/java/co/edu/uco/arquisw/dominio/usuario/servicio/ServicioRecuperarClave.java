package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioRecuperarClave {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioRecuperarClave(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioCifrarTexto servicioCifrarTexto) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public Long ejecutar(Usuario usuario) {
        validarSiNoExisteUsuario(usuario.getCorreo());

        var claveCifrada = this.servicioCifrarTexto.ejecutar(usuario.getClave());
        var id = this.personaRepositorioConsulta.consultarPorCorreo(usuario.getCorreo()).getId();

        return this.personaRepositorioComando.actualizarClave(claveCifrada, id);
    }

    private void validarSiNoExisteUsuario(String correo) {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorCorreo(correo))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_CORREO + correo);
        }
    }
}