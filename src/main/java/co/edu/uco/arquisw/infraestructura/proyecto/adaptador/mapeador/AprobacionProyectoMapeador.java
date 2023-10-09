package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.AprobacionProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.AprobacionProyecto;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.AprobacionProyectoEntidad;
import org.springframework.stereotype.Component;

@Component
public class AprobacionProyectoMapeador {
    public AprobacionProyectoDTO construirDTO(AprobacionProyectoEntidad aprobacionProyecto) {
        return new AprobacionProyectoDTO(aprobacionProyecto.getId(), aprobacionProyecto.isIngenieria(), aprobacionProyecto.isLiderDeEquipo(), aprobacionProyecto.isDirectorDeProyecto());
    }

    public AprobacionProyectoEntidad construirEntidad(AprobacionProyecto aprobacionProyecto) {
        return new AprobacionProyectoEntidad(NumeroConstante.CERO, aprobacionProyecto.isIngenieria(), aprobacionProyecto.isLiderDeEquipo(), aprobacionProyecto.isDirectorDeProyecto());
    }

    public void construirEntidadActualizar(AprobacionProyectoEntidad entidad, String rol) {
        switch (rol) {
            case (TextoConstante.ROL_INGENIERIA) -> entidad.setIngenieria(true);
            case (TextoConstante.ROL_LIDER_DEL_EQUIPO) -> entidad.setLiderDeEquipo(true);
            case (TextoConstante.ROL_DIRECTOR_PROYECTO) -> entidad.setDirectorDeProyecto(true);
            default -> throw new AutorizacionExcepcion(Mensajes.obtenerElRolNoTienePermisosParaAprobarProyecto(rol));
        }
    }
}