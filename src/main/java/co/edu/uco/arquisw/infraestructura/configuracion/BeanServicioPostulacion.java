package co.edu.uco.arquisw.infraestructura.configuracion;


import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.*;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPostulacion {

    @Bean
    public ServicioGuardarPostulacion servicioGuardarPostulacion(PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta)
    {
        return new ServicioGuardarPostulacion(postulacionRepositorioComando, personaRepositorioConsulta, necesidadRepositorioConsulta);
    }
    @Bean
    public ServicioActualizarPostulacion servicioActualizarPostulacion(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PostulacionRepositorioComando postulacionRepositorioComando)
    {
        return new ServicioActualizarPostulacion(postulacionRepositorioConsulta,postulacionRepositorioComando);
    }
    @Bean
    public ServicioConsultarPostulacionPorId servicioConsultarPostulacionPorId(PostulacionRepositorioConsulta postulacionRepositorioConsulta)
    {
        return new ServicioConsultarPostulacionPorId(postulacionRepositorioConsulta);
    }
    @Bean
    public ServicioConsultarPostulacionPorProyecto servicioConsultarPostulacionPorProyecto(PostulacionRepositorioConsulta postulacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta)
    {
        return new ServicioConsultarPostulacionPorProyecto(postulacionRepositorioConsulta,necesidadRepositorioConsulta);
    }
    @Bean
    public ServicioConsultarSeleccinadoPorId servicioConsultarSeleccinadoPorId(PostulacionRepositorioConsulta postulacionRepositorioConsulta)
    {
        return new ServicioConsultarSeleccinadoPorId(postulacionRepositorioConsulta);
    }
    @Bean
    public ServicioConsultarSeleccionadoPorProyecto servicioConsultarSeleccionadoPorProyecto(PostulacionRepositorioConsulta postulacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta)
    {
        return new ServicioConsultarSeleccionadoPorProyecto(postulacionRepositorioConsulta,necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarPostulacionPorUsuarioId servicioConsultarPostulacionPorUsuarioId(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioConsultarPostulacionPorUsuarioId(postulacionRepositorioConsulta, personaRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarSeleccionPorUsuarioId servicioConsultarSeleccionPorUsuarioId(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioConsultarSeleccionPorUsuarioId(postulacionRepositorioConsulta, personaRepositorioConsulta);
    }
}
