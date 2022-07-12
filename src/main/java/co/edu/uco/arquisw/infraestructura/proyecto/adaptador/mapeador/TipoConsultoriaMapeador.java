package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.TipoConsultoriaDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.TipoConsultoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.TipoConsultoriaEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.TipoConsultoriaProyectoEntidad;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolPersonaEntidad;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.RolMapeador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoConsultoriaMapeador
{
    public TipoConsultoriaDTO construirDTO(TipoConsultoriaProyectoEntidad tipoConsultoria)
    {
        return new TipoConsultoriaDTO(tipoConsultoria.getTipoConsultoria().getNombre());
    }

    public List<TipoConsultoriaDTO> construirDTOs(List<TipoConsultoriaProyectoEntidad> roles)
    {
        return roles.stream().map(new TipoConsultoriaMapeador()::construirDTO).toList();
    }

    public TipoConsultoriaProyectoEntidad construirEntidad(TipoConsultoria tipoConsultoria)
    {
        return new TipoConsultoriaProyectoEntidad(0L, new TipoConsultoriaEntidad(obtenerRolID(tipoConsultoria.getNombre()), tipoConsultoria.getNombre()));
    }

    public List<TipoConsultoriaProyectoEntidad> construirEntidades(List<TipoConsultoria> tiposConsultoria)
    {
        return tiposConsultoria.stream().map(new TipoConsultoriaMapeador()::construirEntidad).toList();
    }

    private Long obtenerRolID(String nombre)
    {
        return switch (nombre) {
            case TextoConstante.ESTADO_EN_ESPERA -> 1L;
            case TextoConstante.ESTADO_APROBADO -> 2L;
            case TextoConstante.ESTADO_EN_DESARROLLO -> 3L;
            case TextoConstante.ESTADO_FINALIZADO -> 4L;
            default -> 0L;
        };
    }
}