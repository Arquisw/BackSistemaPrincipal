package co.edu.uco.arquisw.dominio.ensamblador;

import co.edu.uco.arquisw.aplicacion.dto.EstadoAsociacionDTO;
import co.edu.uco.arquisw.dominio.modelo.EstadoAsociacion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoAsociacionEntidad;

public interface EstadoAsociacionEnsamblador extends Ensamblador<EstadoAsociacion, EstadoAsociacionEntidad, EstadoAsociacionDTO>
{
    EstadoAsociacionEntidad ensamblarEntidadDesdeDominioParaGuardar(int codigo, EstadoEntidad estado);
}