package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.EstadoNecesidadDTO;
import co.edu.uco.arquisw.dominio.ensamblador.EstadoNecesidadEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoNecesidadEntidad;

public class EstadoNecesidadEnsambladorImplementacion implements EstadoNecesidadEnsamblador
{
    private static final EstadoNecesidadEnsamblador INSTANCE = new EstadoNecesidadEnsambladorImplementacion();

    private EstadoNecesidadEnsambladorImplementacion()
    {

    }

    public static EstadoNecesidadEnsamblador obtenerEstadoNecesidadEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public EstadoNecesidad ensamblarDominioDesdeEntidad(EstadoNecesidadEntidad entidad)
    {
        return EstadoNecesidad.crear(entidad.getCodigo(), entidad.getEstado().getNombre());
    }

    @Override
    public EstadoNecesidadEntidad ensamblarEntidadDesdeDominio(EstadoNecesidad dominio)
    {
        int codigo = 0;

        // Asignar estados de una necesidad

        return new EstadoNecesidadEntidad(codigo, new EstadoEntidad(dominio.getCodigo(), dominio.getNombre()));
    }

    @Override
    public EstadoNecesidad ensamblarDominioDesdeDTO(EstadoNecesidadDTO dto)
    {
        return EstadoNecesidad.crear(dto.getCodigo(), dto.getNombre());
    }

    @Override
    public EstadoNecesidadDTO ensamblarDTODesdeDominio(EstadoNecesidad dominio)
    {
        return new EstadoNecesidadDTO(dominio.getCodigo(), dominio.getNombre());
    }
}