package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarProyectoPorId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarProyectoPorIdManejador implements ManejadorComandoRespuesta<Long, ProyectoDTO>
{
    private final ServicioConsultarProyectoPorId servicioConsultarProyectoPorId;

    public ConsultarProyectoPorIdManejador(ServicioConsultarProyectoPorId servicioConsultarProyectoPorId)
    {
        this.servicioConsultarProyectoPorId = servicioConsultarProyectoPorId;
    }

    @Override
    public ProyectoDTO ejecutar(Long comando)
    {
        return this.servicioConsultarProyectoPorId.ejecutar(comando);
    }
}