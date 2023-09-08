package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioCifrarTexto;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioActualizarClave {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioCifrarTexto servicioCifrarTexto;
    private final ServicioObtenerRoles servicioObtenerRoles;

    public ServicioActualizarClave(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioCifrarTexto servicioCifrarTexto, ServicioObtenerRoles servicioObtenerRoles) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioCifrarTexto = servicioCifrarTexto;
        this.servicioObtenerRoles = servicioObtenerRoles;
    }

    public Long ejecutar(String claveAntigua, String claveNueva, Long id) {
        validarSiNoExisteUsuario(id);
        validarSiClaveNuevaNoEsLaAntigua(claveAntigua, claveNueva);

        var usuario = this.personaRepositorioConsulta.consultarUsuarioPorId(id);

        validarSiClaveAntiguaExiste(claveAntigua, usuario.getCorreo());

        var usuarioActualizado = Usuario.crear(usuario.getCorreo(), claveNueva, this.servicioObtenerRoles.obtenerRolesPorDefectoActualizar(usuario.getCorreo()));
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

    private void validarSiClaveAntiguaExiste(String claveAntigua, String correo) {
        var claveCifrada = this.personaRepositorioConsulta.consultarClaveConCorreo(correo);

        if(!this.servicioCifrarTexto.existe(claveAntigua, claveCifrada)) {
            throw new ValorInvalidoExcepcion(Mensajes.LA_CLAVE_ANTIGUA_ES_INCORRECTA);
        }
    }
}