package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioCifrarTexto;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioUsuario {
    @Bean
    public ServicioGuardarPersona servicioGuardarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioCifrarTexto servicioCifrarTexto, ServicioObtenerRoles servicioObtenerRoles) {
        return new ServicioGuardarPersona(personaRepositorioComando, personaRepositorioConsulta, servicioCifrarTexto, servicioObtenerRoles);
    }

    @Bean
    public ServicioActualizarPersona servicioActualizarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioActualizarPersona(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioEliminarPersonaPorAdministrador servicioEliminarPersonaPorAdministrador(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        return new ServicioEliminarPersonaPorAdministrador(personaRepositorioComando, personaRepositorioConsulta, servicioEnviarCorreoElectronico);
    }

    @Bean
    public ServicioEliminarPersona servicioEliminarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PostulacionRepositorioConsulta postulacionRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        return new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta, asociacionRepositorioConsulta, postulacionRepositorioConsulta, servicioEnviarCorreoElectronico);
    }


    @Bean
    public ServicioConsultarPersonaPorId servicioConsultarUsuarioPorId(PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioConsultarPersonaPorId(personaRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarHojaDeVida servicioActualizarHojaDeVida(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioActualizarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarHojaDeVidaPorIdUsuario servicioConsultarHojaDeVidaPorIdUsuario(PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioConsultarHojaDeVidaPorIdUsuario(personaRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarPersonaPorCorreo servicioConsultarPersonaPorCorreo(PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioConsultarPersonaPorCorreo(personaRepositorioConsulta);
    }

    @Bean
    public ServicioGuardarHojaDeVida servicioGuardarHojaDeVida(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioGuardarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioLogin servicioLogin(PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioLogin(personaRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarClave servicioActualizarClave(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioCifrarTexto servicioCifrarTexto, ServicioObtenerRoles servicioObtenerRoles) {
        return new ServicioActualizarClave(personaRepositorioComando, personaRepositorioConsulta, servicioCifrarTexto, servicioObtenerRoles);
    }

    @Bean
    public ServicioIniciarRecuperacionClave servicioIniciarRecuperacionClave(ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico, PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioCifrarTexto servicioCifrarTexto) {
        return new ServicioIniciarRecuperacionClave(servicioEnviarCorreoElectronico, personaRepositorioConsulta, personaRepositorioComando, servicioCifrarTexto);
    }

    @Bean
    public ServicioRecuperarClave servicioRecuperarClave(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioCifrarTexto servicioCifrarTexto, ServicioObtenerRoles servicioObtenerRoles) {
        return new ServicioRecuperarClave(personaRepositorioComando, personaRepositorioConsulta, servicioCifrarTexto, servicioObtenerRoles);
    }

    @Bean
    public ServicioValidarCodigoRecuperacionClave servicioValidarCodigoRecuperacionClave(PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioCifrarTexto servicioCifrarTexto) {
        return new ServicioValidarCodigoRecuperacionClave(personaRepositorioConsulta, personaRepositorioComando, servicioCifrarTexto);
    }

    @Bean
    public ServicioObtenerRoles servicioObtenerRoles(PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioObtenerRoles(personaRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarRolPorAdministrador servicioActualizarRolPorAdministrador(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioActualizarRolPorAdministrador(personaRepositorioComando, personaRepositorioConsulta);
    }
}