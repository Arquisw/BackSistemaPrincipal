package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioActualizarPersona;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioConsultarPersonaPorId;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioEliminarPersona;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioGuardarPersona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioUsuario
{
    @Bean
    public ServicioGuardarPersona servicioGuardarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioGuardarPersona(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarPersona servicioActualizarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioActualizarPersona(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioEliminarPersona servicioEliminarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarPersonaPorId servicioConsultarUsuarioPorId(PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioConsultarPersonaPorId(personaRepositorioConsulta);
    }
}