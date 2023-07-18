package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import lombok.Getter;

@Getter
public class ServicioActualizarClave {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioActualizarClave(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioCifrarTexto servicioCifrarTexto) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public Long ejecutar(String claveAntigua, String claveNueva, Long id) {
        validarSiNoExisteUsuario(id);
        validarSiClaveNuevaNoEsLaAntigua(claveAntigua, claveNueva);
        validarSiClaveAntiguaExiste(claveAntigua);

        var usuario = this.personaRepositorioConsulta.consultarPorId(id);
        var usuarioActualizado = Usuario.crear(usuario.getCorreo(), claveNueva);
        var claveCifrada = this.servicioCifrarTexto.ejecutar(usuarioActualizado.getClave());

        return this.personaRepositorioComando.actualizarClave(claveCifrada, id);
    }

    private void validarSiNoExisteUsuario(Long id) {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }

    private void validarSiClaveNuevaNoEsLaAntigua(String claveAntigua, String claveNueva) {
        if(claveNueva.equals(claveAntigua)) {
            throw new ValorInvalidoExcepcion(Mensajes.LA_CLAVE_NUEVA_NO_PUEDE_SER_IGUAL_A_LA_ANTIGUA);
        }
    }

    private void validarSiClaveAntiguaExiste(String claveAntigua) {
        var claveCifrada = this.servicioCifrarTexto.ejecutar(claveAntigua);

        if(!this.personaRepositorioConsulta.usuarioExisteConClave(claveCifrada)) {
            throw new ValorInvalidoExcepcion(Mensajes.LA_CLAVE_ANTIGUA_ES_INCORRECTA);
        }
    }
}