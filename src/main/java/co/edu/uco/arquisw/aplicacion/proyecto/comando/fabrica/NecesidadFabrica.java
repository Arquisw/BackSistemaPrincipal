package co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.ProyectoComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarNecesidadPorId;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import org.springframework.stereotype.Component;

@Component
public class NecesidadFabrica {
    private final ProyectoFabrica proyectoFabrica;
    private final ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId;

    public NecesidadFabrica(ProyectoFabrica proyectoFabrica, ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId) {
        this.proyectoFabrica = proyectoFabrica;
        this.servicioConsultarNecesidadPorId = servicioConsultarNecesidadPorId;
    }

    public Necesidad construir(ProyectoComando proyecto) {
        return Necesidad.crear(obtenerEstadoPorDefecto(), proyectoFabrica.construir(proyecto));
    }

    public Necesidad construirActualizar(ProyectoComando proyecto, Long id) {
        return Necesidad.crear(obtenerEstadoPorDefectoActualizar(id), proyectoFabrica.construirActualizar(proyecto, id));
    }

    private EstadoNecesidad obtenerEstadoPorDefectoActualizar(Long id) {
        var necesidad = this.servicioConsultarNecesidadPorId.ejecutar(id);

        return EstadoNecesidad.crear(necesidad.getEstado().getNombre());
    }

    private EstadoNecesidad obtenerEstadoPorDefecto() {
        return EstadoNecesidad.crear(TextoConstante.ESTADO_EN_ESPERA);
    }
}