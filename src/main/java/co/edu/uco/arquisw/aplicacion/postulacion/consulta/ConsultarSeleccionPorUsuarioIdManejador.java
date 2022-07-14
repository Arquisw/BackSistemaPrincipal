package co.edu.uco.arquisw.aplicacion.postulacion.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarSeleccionPorUsuarioId;

public class ConsultarSeleccionPorUsuarioIdManejador implements ManejadorComandoRespuesta<Long, SeleccionDTO>
{
    private final ServicioConsultarSeleccionPorUsuarioId servicioConsultarSeleccionPorUsuarioId;

    public ConsultarSeleccionPorUsuarioIdManejador(ServicioConsultarSeleccionPorUsuarioId servicioConsultarSeleccionPorUsuarioId)
    {
        this.servicioConsultarSeleccionPorUsuarioId = servicioConsultarSeleccionPorUsuarioId;
    }


    @Override
    public SeleccionDTO ejecutar(Long comando)
    {
        return this.servicioConsultarSeleccionPorUsuarioId.ejecutar(comando);
    }
}