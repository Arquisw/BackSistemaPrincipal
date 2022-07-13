package co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.fabrica.PostulacionFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioActualizarPostulacion;
import org.springframework.stereotype.Component;

@Component
public class ActualizarPostulacionManejador implements ManejadorComandoActualizacionRespuesta<PostulacionComando, Long, ComandoRespuesta<Long>>
{
    private final PostulacionFabrica postulacionFabrica;
    private final ServicioActualizarPostulacion servicioActualizarPostulacion;

    public ActualizarPostulacionManejador(PostulacionFabrica postulacionFabrica, ServicioActualizarPostulacion servicioActualizarPostulacion) {
        this.postulacionFabrica = postulacionFabrica;
        this.servicioActualizarPostulacion = servicioActualizarPostulacion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(PostulacionComando comando, Long id)
    {
        return new ComandoRespuesta<>(this.servicioActualizarPostulacion.ejecutar(this.postulacionFabrica.construir(), id));
    }
}