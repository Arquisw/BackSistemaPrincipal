package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.FaseRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.*;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioProyecto {
    @Bean
    public ServicioGuardarNecesidad servicioGuardarNecesidad(NecesidadRepositorioComando necesidadRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        return new ServicioGuardarNecesidad(necesidadRepositorioComando, asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarNecesidad servicioActualizarNecesidad(AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando) {
        return new ServicioActualizarNecesidad(asociacionRepositorioConsulta, necesidadRepositorioComando);
    }

    @Bean
    public ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarNecesidadPorId(necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarProyectoPorId servicioConsultarProyectoPorId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarProyectoPorId(necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioEliminarNecesidad servicioEliminarNecesidad(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioEliminarNecesidad(necesidadRepositorioConsulta, necesidadRepositorioComando, asociacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioEliminarNecesidadPorAdministrador servicioEliminarNecesidadPorAdministrador(AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioEliminarNecesidadPorAdministrador(asociacionRepositorioConsulta, necesidadRepositorioComando, necesidadRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioAprobarProyecto servicioAprobarProyecto(NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioAprobarProyecto(necesidadRepositorioComando, necesidadRepositorioConsulta, asociacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioAprobarProyectoPorRolDirectorDeProyecto servicioAprobarProyectoPorRolDirectorDeProyecto(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, FaseRepositorioComando faseRepositorioComando, PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioAprobarProyectoPorRolDirectorDeProyecto(necesidadRepositorioConsulta, necesidadRepositorioComando, faseRepositorioComando, postulacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioAprobarProyectoPorRolIngenieria servicioAprobarProyectoPorRolIngenieria(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioAprobarProyectoPorRolIngenieria(necesidadRepositorioConsulta, necesidadRepositorioComando, postulacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioAprobarProyectoPorRolLiderDeEquipo servicioAprobarProyectoPorRolLiderDeEquipo(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioAprobarProyectoPorRolLiderDeEquipo(necesidadRepositorioConsulta, necesidadRepositorioComando, postulacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioConsultarNecesidadesPorAsociacionId servicioConsultarNecesidadesPorAsociacionId(NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        return new ServicioConsultarNecesidadesPorAsociacionId(necesidadRepositorioConsulta, asociacionRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarNecesidadPorProyectoId servicioConsultarNecesidadPorProyectoId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarNecesidadPorProyectoId(necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioGuardarRequerimientos servicioGuardarRequerimientos(NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioGuardarRequerimientos(necesidadRepositorioComando, necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarRequerimientos servicioActualizarRequerimientos(NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioActualizarRequerimientos(necesidadRepositorioComando, necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarRequerimientosPorNecesidadId servicioConsultarRequerimientosPorNecesidadId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarRequerimientosPorNecesidadId(necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioRechazarProyecto servicioRechazarProyecto(NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        return new ServicioRechazarProyecto(necesidadRepositorioComando, necesidadRepositorioConsulta, asociacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);
    }

    @Bean
    public ServicioUsuarioEsPropetarioDelProyecto servicioUsuarioEsPropetarioDelProyecto(PersonaRepositorioConsulta personaRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        return new ServicioUsuarioEsPropetarioDelProyecto(personaRepositorioConsulta, necesidadRepositorioConsulta, asociacionRepositorioConsulta);
    }
}