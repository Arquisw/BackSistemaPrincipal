package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.FaseRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioProyecto
{
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
    public ServicioEliminarNecesidad servicioEliminarNecesidad(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando) {
        return new ServicioEliminarNecesidad(necesidadRepositorioConsulta, necesidadRepositorioComando);
    }

    @Bean
    public ServicioEliminarNecesidadPorAdministrador servicioEliminarNecesidadPorAdministrador(AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando) {
        return new ServicioEliminarNecesidadPorAdministrador(asociacionRepositorioConsulta, necesidadRepositorioComando);
    }

    @Bean
    public ServicioAprobarProyecto servicioAprobarProyecto(NecesidadRepositorioComando necesidadRepositorioComando, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioAprobarProyecto(necesidadRepositorioComando, necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioAprobarProyectoPorRolDirectorDeProyecto servicioAprobarProyectoPorRolDirectorDeProyecto(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, FaseRepositorioComando faseRepositorioComando) {
        return new ServicioAprobarProyectoPorRolDirectorDeProyecto(necesidadRepositorioConsulta, necesidadRepositorioComando, faseRepositorioComando);
    }

    @Bean
    public ServicioAprobarProyectoPorRolIngenieria servicioAprobarProyectoPorRolIngenieria(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, ContratoRepositorioConsulta contratoRepositorioConsulta) {
        return new ServicioAprobarProyectoPorRolIngenieria(necesidadRepositorioConsulta, necesidadRepositorioComando, contratoRepositorioConsulta);
    }

    @Bean
    public ServicioAprobarProyectoPorRolLiderDeEquipo servicioAprobarProyectoPorRolLiderDeEquipo(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando) {
        return new ServicioAprobarProyectoPorRolLiderDeEquipo(necesidadRepositorioConsulta, necesidadRepositorioComando);
    }

    @Bean
    public ServicioConsultarAprobacionProyectoPorId servicioConsultarAprobacionProyectoPorId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        return new ServicioConsultarAprobacionProyectoPorId(necesidadRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarNecesidadesPorAsociacionId servicioConsultarNecesidadesPorAsociacionId(NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        return new ServicioConsultarNecesidadesPorAsociacionId(necesidadRepositorioConsulta, asociacionRepositorioConsulta);
    }
}