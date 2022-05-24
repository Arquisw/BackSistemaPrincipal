package co.edu.uco.arquisw.dominio.ensamblador;

import co.edu.uco.arquisw.aplicacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.modelo.Asociacion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.AsociacionEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoAsociacionEntidad;

public interface AsociacionEnsamblador extends Ensamblador<Asociacion, AsociacionEntidad, AsociacionDTO>
{
    AsociacionEntidad ensamblarEntidadDesdeDominioParaGuardar(Asociacion dominio, EstadoAsociacionEntidad estado);
}