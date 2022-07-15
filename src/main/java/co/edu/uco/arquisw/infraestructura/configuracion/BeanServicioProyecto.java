package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioProyecto
{
    @Bean
    public ServicioGuardarNecesidad servicioGuardarNecesidad(NecesidadRepositorioComando necesidadRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        return new ServicioGuardarNecesidad(necesidadRepositorioComando, asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarNecesidad servicioActualizarNecesidad(AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando)
    {
        return new ServicioActualizarNecesidad(asociacionRepositorioConsulta, necesidadRepositorioComando);
    }

    @Bean
    public ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId(NecesidadRepositorioConsulta necesidadRepositorioConsulta)
    {
        return new ServicioConsultarNecesidadPorId(necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarProyectoPorId servicioConsultarProyectoPorId(NecesidadRepositorioConsulta necesidadRepositorioConsulta)
    {
        return new ServicioConsultarProyectoPorId(necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioEliminarNecesidad servicioEliminarNecesidad(AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando)
    {
        return new ServicioEliminarNecesidad(asociacionRepositorioComando, asociacionRepositorioConsulta, necesidadRepositorioConsulta, necesidadRepositorioComando);
    }

    @Bean
    public ServicioEliminarNecesidadPorAdministrador servicioEliminarNecesidadPorAdministrador(AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando)
    {
        return new ServicioEliminarNecesidadPorAdministrador(asociacionRepositorioConsulta, necesidadRepositorioComando);
    }
}