package co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.NecesidadComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarNecesidadPorId;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import org.springframework.stereotype.Component;

@Component
public class NecesidadFabrica
{
    private final ProyectoFabrica proyectoFabrica;
    private final ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId;

    public NecesidadFabrica(ProyectoFabrica proyectoFabrica, ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId)
    {
        this.proyectoFabrica = proyectoFabrica;
        this.servicioConsultarNecesidadPorId = servicioConsultarNecesidadPorId;
    }

    public Necesidad construir(NecesidadComando necesidad)
    {
        return Necesidad.crear(necesidad.getRutaArchivo(), obtenerEstadoPorDefecto(), proyectoFabrica.construir(necesidad.getProyecto()));
    }

    public Necesidad construirActualizar(NecesidadComando necesidad, Long id)
    {
        return Necesidad.crear(necesidad.getRutaArchivo(), obtenerEstadoPorDefectoActualizar(id), proyectoFabrica.construirActualizar(necesidad.getProyecto(), id));
    }

    private EstadoNecesidad obtenerEstadoPorDefectoActualizar(Long id)
    {
        var necesidad = this.servicioConsultarNecesidadPorId.ejecutar(id);

        return EstadoNecesidad.crear(necesidad.getEstado().getNombre());
    }

    private EstadoNecesidad obtenerEstadoPorDefecto()
    {
        return EstadoNecesidad.crear(TextoConstante.ESTADO_EN_ESPERA);
    }
}