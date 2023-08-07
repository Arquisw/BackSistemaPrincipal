package co.edu.uco.arquisw.aplicacion.proyecto.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarNecesidadPorProyectoId;
import org.springframework.stereotype.Component;

@Component
public class ConsultarNecesidadPorProyectoIdManejador implements ManejadorComandoRespuesta<Long, NecesidadDTO> {
    private final ServicioConsultarNecesidadPorProyectoId servicioConsultarNecesidadPorProyectoId;

    public ConsultarNecesidadPorProyectoIdManejador(ServicioConsultarNecesidadPorProyectoId servicioConsultarNecesidadPorProyectoId) {
        this.servicioConsultarNecesidadPorProyectoId = servicioConsultarNecesidadPorProyectoId;
    }

    @Override
    public NecesidadDTO ejecutar(Long comando) {
        return this.servicioConsultarNecesidadPorProyectoId.ejecutar(comando);
    }
}