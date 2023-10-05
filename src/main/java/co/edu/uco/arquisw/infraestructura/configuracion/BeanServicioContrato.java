package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioActualizarContrato;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioConsultarContratoPorId;
import co.edu.uco.arquisw.dominio.contrato.servicio.ServicioGuardarContrato;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioContrato {
    @Bean
    public ServicioGuardarContrato servicioGuardarContrato(ContratoRepositorioComando contratoRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioGuardarContrato(contratoRepositorioComando, necesidadRepositorioConsulta, necesidadRepositorioComando, asociacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioActualizarContrato servicioActualizarContrato(ContratoRepositorioComando contratoRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioActualizarContrato(contratoRepositorioComando, necesidadRepositorioConsulta, asociacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioConsultarContratoPorId servicioConsultarContratoPorId(ContratoRepositorioConsulta contratoRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarContratoPorId(contratoRepositorioConsulta, necesidadRepositorioConsulta);
    }
}