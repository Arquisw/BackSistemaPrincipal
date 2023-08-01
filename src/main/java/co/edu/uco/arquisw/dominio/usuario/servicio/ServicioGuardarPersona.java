package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioGuardarPersona {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioCifrarTexto servicioCifrarTexto;
    private final ServicioObtenerRoles servicioObtenerRoles;

    public ServicioGuardarPersona(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioCifrarTexto servicioCifrarTexto, ServicioObtenerRoles servicioObtenerRoles) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioCifrarTexto = servicioCifrarTexto;
        this.servicioObtenerRoles = servicioObtenerRoles;
    }

    public Long ejecutar(Persona persona, String clave) {
        validarSiExistePersonaConCorreo(persona);

        var usuario = Usuario.crear(persona.getCorreo(), clave, this.servicioObtenerRoles.obtenerRolesPorDefecto());
        var claveCifrada = this.servicioCifrarTexto.ejecutar(clave);

        return this.personaRepositorioComando.guardar(persona, usuario, claveCifrada);
    }

    private void validarSiExistePersonaConCorreo(Persona persona) {
        if(!ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorCorreo(persona.getCorreo()))) {
            throw new ValorInvalidoExcepcion(Mensajes.EXISTE_USUARIO_CON_CORREO);
        }
    }
}