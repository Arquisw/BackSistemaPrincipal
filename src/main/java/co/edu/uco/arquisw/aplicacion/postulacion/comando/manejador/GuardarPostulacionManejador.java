package co.edu.uco.arquisw.aplicacion.postulacion.comando.manejador;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.fabrica.PostulacionFabrica;
import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioGuardarPostulacion;
import org.springframework.stereotype.Component;

@Component
public class GuardarPostulacionManejador implements ManejadorComandoRespuesta<PostulacionComando, ComandoRespuesta<Long>>
{
    private final PostulacionFabrica postulacionFabrica;
    private final ServicioGuardarPostulacion servicioGuardarPostulacion;

    public GuardarPostulacionManejador(PostulacionFabrica postulacionFabrica, ServicioGuardarPostulacion servicioGuardarPostulacion)
    {
        this.postulacionFabrica = postulacionFabrica;
        this.servicioGuardarPostulacion = servicioGuardarPostulacion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(PostulacionComando comando)
    {
        return new ComandoRespuesta<>(this.servicioGuardarPostulacion.ejecutar(this.postulacionFabrica.construir(comando), comando.getProyectoID(), comando.getUsuarioID()));
    }
}