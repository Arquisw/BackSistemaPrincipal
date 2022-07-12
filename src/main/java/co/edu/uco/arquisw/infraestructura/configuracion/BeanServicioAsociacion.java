package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioActualizarAsociacion;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioConsultarAsociacionPorID;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioGuardarAsociacion;
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
}