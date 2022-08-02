package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.*;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioAsociacion
{
    @Bean
    public ServicioGuardarAsociacion servicioGuardarAsociacion(AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioGuardarAsociacion(asociacionRepositorioComando, asociacionRepositorioConsulta, personaRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarAsociacion servicioActualizarAsociacion(AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        return new ServicioActualizarAsociacion(asociacionRepositorioComando, asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarAsociacionPorID servicioConsultarAsociacionPorID(AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        return new ServicioConsultarAsociacionPorID(asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioEliminarAsociacion servicioEliminarAsociacion(PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando)
    {
        return new ServicioEliminarAsociacion(personaRepositorioConsulta, asociacionRepositorioComando, asociacionRepositorioConsulta, necesidadRepositorioConsulta, personaRepositorioComando);
    }

    @Bean
    public ServicioEliminarAsociacionPorAdministrador servicioEliminarAsociacionPorAdministrador(PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioComando asociacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando)
    {
        return new ServicioEliminarAsociacionPorAdministrador(personaRepositorioConsulta, asociacionRepositorioComando, personaRepositorioComando);
    }
}