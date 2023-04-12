package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.FaseRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioActualizarContrato;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioConsultarContratoPorId;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioGuardarContrato;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioContrato {
    @Bean
    public ServicioGuardarContrato servicioGuardarContrato(ContratoRepositorioComando contratoRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, FaseRepositorioComando faseRepositorioComando) {
        return new ServicioGuardarContrato(contratoRepositorioComando, necesidadRepositorioConsulta, necesidadRepositorioComando, faseRepositorioComando);
    }

    @Bean
    public ServicioActualizarContrato servicioActualizarContrato(ContratoRepositorioComando contratoRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        return new ServicioActualizarContrato(contratoRepositorioComando, asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarContratoPorId servicioConsultarContratoPorId(ContratoRepositorioConsulta contratoRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarContratoPorId(contratoRepositorioConsulta, necesidadRepositorioConsulta);
    }
}