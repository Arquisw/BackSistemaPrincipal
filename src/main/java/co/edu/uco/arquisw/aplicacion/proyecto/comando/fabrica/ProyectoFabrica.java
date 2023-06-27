package co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.ProyectoComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.AprobacionProyecto;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Proyecto;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarAprobacionProyectoPorId;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioConsultarNecesidadPorId;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import org.springframework.stereotype.Component;

@Component
public class ProyectoFabrica {
    private final TipoConsultoriaFabrica tipoConsultoriaFabrica;
    private final ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId;
    private final ServicioConsultarAprobacionProyectoPorId servicioConsultarAprobacionProyectoPorId;

    public ProyectoFabrica(TipoConsultoriaFabrica tipoConsultoriaFabrica, ServicioConsultarNecesidadPorId servicioConsultarNecesidadPorId, ServicioConsultarAprobacionProyectoPorId servicioConsultarAprobacionProyectoPorId) {
        this.tipoConsultoriaFabrica = tipoConsultoriaFabrica;
        this.servicioConsultarNecesidadPorId = servicioConsultarNecesidadPorId;
        this.servicioConsultarAprobacionProyectoPorId = servicioConsultarAprobacionProyectoPorId;
    }

    public Proyecto construir(ProyectoComando proyecto) {
        return Proyecto.crear(proyecto.getNombre(), proyecto.getDescripcion(), obtenerEstadoPorDefecto(), tipoConsultoriaFabrica.construirTodos(proyecto.getTiposConsultoria()));
    }

    public Proyecto construirActualizar(ProyectoComando proyecto, Long id) {
        return Proyecto.modificar(proyecto.getNombre(), proyecto.getDescripcion(), obtenerEstadoPorDefectoActualizar(id), obtenerAprobacionProyectoActualParaActualizar(id), tipoConsultoriaFabrica.construirTodos(proyecto.getTiposConsultoria()));
    }

    private EstadoProyecto obtenerEstadoPorDefectoActualizar(Long id) {
        var necesidad = this.servicioConsultarNecesidadPorId.ejecutar(id);

        return EstadoProyecto.crear(necesidad.getProyecto().getEstado().getNombre());
    }

    private AprobacionProyecto obtenerAprobacionProyectoActualParaActualizar(Long id) {
        var aprobacionProyectoDTO = this.servicioConsultarAprobacionProyectoPorId.ejecutar(id);

        return AprobacionProyecto.modificar(aprobacionProyectoDTO.isIngenieria(), aprobacionProyectoDTO.isLiderDeEquipo(), aprobacionProyectoDTO.isDirectorDeProyecto());
    }

    private EstadoProyecto obtenerEstadoPorDefecto() {
        return EstadoProyecto.crear(TextoConstante.ESTADO_EN_ESPERA);
    }
}