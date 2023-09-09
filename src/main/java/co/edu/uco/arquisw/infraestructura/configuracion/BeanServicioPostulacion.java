package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.*;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPostulacion {
    @Bean
    public ServicioGuardarPostulacion servicioGuardarPostulacion(PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, ServicioActualizarToken servicioActualizarToken) {
        return new ServicioGuardarPostulacion(postulacionRepositorioComando, personaRepositorioConsulta, necesidadRepositorioConsulta, personaRepositorioComando, servicioActualizarToken);
    }

    @Bean
    public ServicioActualizarPostulacion servicioActualizarPostulacion(PostulacionRepositorioComando postulacionRepositorioComando, PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioActualizarPostulacion(postulacionRepositorioComando, postulacionRepositorioConsulta, personaRepositorioConsulta, necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioSeleccionarUsuario servicioSeleccionarUsuario(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando, ServicioActualizarToken servicioActualizarToken) {
        return new ServicioSeleccionarUsuario(postulacionRepositorioConsulta, postulacionRepositorioComando, personaRepositorioComando, servicioActualizarToken);
    }

    @Bean
    public ServicioConsultarPostulacionPorId servicioConsultarPostulacionPorId(PostulacionRepositorioConsulta postulacionRepositorioConsulta) {
        return new ServicioConsultarPostulacionPorId(postulacionRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarPostulacionPorProyecto servicioConsultarPostulacionPorProyecto(PostulacionRepositorioConsulta postulacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarPostulacionPorProyecto(postulacionRepositorioConsulta, necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarSeleccinadoPorId servicioConsultarSeleccinadoPorId(PostulacionRepositorioConsulta postulacionRepositorioConsulta) {
        return new ServicioConsultarSeleccinadoPorId(postulacionRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarSeleccionadoPorProyecto servicioConsultarSeleccionadoPorProyecto(PostulacionRepositorioConsulta postulacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarSeleccionadoPorProyecto(postulacionRepositorioConsulta, necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarPostulacionesPorUsuarioId servicioConsultarPostulacionPorUsuarioId(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioConsultarPostulacionesPorUsuarioId(postulacionRepositorioConsulta, personaRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarSeleccionesPorUsuarioId servicioConsultarSeleccionPorUsuarioId(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ServicioConsultarSeleccionesPorUsuarioId(postulacionRepositorioConsulta, personaRepositorioConsulta);
    }

    @Bean
    public ServicioRechazarUsuario servicioRechazarUsuario(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PostulacionRepositorioComando postulacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando, ServicioActualizarToken servicioActualizarToken) {
        return new ServicioRechazarUsuario(postulacionRepositorioConsulta, postulacionRepositorioComando, personaRepositorioComando, servicioActualizarToken);
    }
}