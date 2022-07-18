package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioActualizarContrato;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioConsultarContratoPorId;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioEliminarContrato;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioGuardarContrato;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioContrato
{
    @Bean
    public ServicioGuardarContrato servicioGuardarContrato(ContratoRepositorioComando contratoRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        return new ServicioGuardarContrato(contratoRepositorioComando, asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarContrato servicioActualizarContrato(ContratoRepositorioComando contratoRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        return new ServicioActualizarContrato(contratoRepositorioComando, asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioEliminarContrato servicioEliminarContrato(ContratoRepositorioComando contratoRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        return new ServicioEliminarContrato(contratoRepositorioComando, asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarContratoPorId servicioConsultarContratoPorId(ContratoRepositorioConsulta contratoRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        return new ServicioConsultarContratoPorId(contratoRepositorioConsulta, asociacionRepositorioConsulta);
    }
}