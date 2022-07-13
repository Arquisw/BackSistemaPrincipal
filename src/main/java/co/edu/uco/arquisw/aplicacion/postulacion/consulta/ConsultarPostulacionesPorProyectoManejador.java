package co.edu.uco.arquisw.aplicacion.postulacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarPostulacionPorProyecto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ConsultarPostulacionesPorProyectoManejador implements ManejadorComandoRespuesta<Long, List<PostulacionDTO>>
{
    private final ServicioConsultarPostulacionPorProyecto servicioConsultarPostulacionPorProyecto;

    public ConsultarPostulacionesPorProyectoManejador(ServicioConsultarPostulacionPorProyecto servicioConsultarPostulacionPorProyecto)
    {
        this.servicioConsultarPostulacionPorProyecto = servicioConsultarPostulacionPorProyecto;
    }

    @Override
    public List<PostulacionDTO> ejecutar(Long comando)
    {
        return this.servicioConsultarPostulacionPorProyecto.ejecutar(comando);
    }
}