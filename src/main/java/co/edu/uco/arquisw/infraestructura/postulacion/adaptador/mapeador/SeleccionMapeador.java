package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.SeleccionEntidad;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SeleccionMapeador
{
    public SeleccionDTO construirDTO(SeleccionEntidad seleccion)
    {
        return new SeleccionDTO(seleccion.getId(), seleccion.getFecha(), seleccion.getProyecto(), seleccion.getUsuario());
    }

    public List<SeleccionDTO> construirDTOs(List<SeleccionEntidad> selecciones)
    {
        return selecciones.stream().map(new SeleccionMapeador()::construirDTO).toList();
    }

    public SeleccionEntidad construirEntidad(Seleccion postulacion, Long proyectoID, Long usuarioID)
    {
        return new SeleccionEntidad(0L, FechaFormateador.obtenerFechaTexto(postulacion.getFecha()), proyectoID, usuarioID);
    }
}