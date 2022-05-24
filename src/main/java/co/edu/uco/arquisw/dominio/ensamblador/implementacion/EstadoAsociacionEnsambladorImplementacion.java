package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.EstadoAsociacionDTO;
import co.edu.uco.arquisw.dominio.ensamblador.EstadoAsociacionEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.EstadoAsociacion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoAsociacionEntidad;

public class EstadoAsociacionEnsambladorImplementacion implements EstadoAsociacionEnsamblador
{
    private static final EstadoAsociacionEnsamblador INSTANCE = new EstadoAsociacionEnsambladorImplementacion();

    private EstadoAsociacionEnsambladorImplementacion()
    {

    }

    public static EstadoAsociacionEnsamblador obtenerEstadoAsociacionEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public EstadoAsociacion ensamblarDominioDesdeEntidad(EstadoAsociacionEntidad entidad)
    {
        return EstadoAsociacion.crear(entidad.getCodigo(), entidad.getEstado().getNombre());
    }

    @Override
    public EstadoAsociacionEntidad ensamblarEntidadDesdeDominio(EstadoAsociacion dominio)
    {
        var codigo = 0;

        // Asignar tipos de Estado

        return new EstadoAsociacionEntidad(dominio.getCodigo(), new EstadoEntidad(codigo, dominio.getNombre()));
    }

    @Override
    public EstadoAsociacion ensamblarDominioDesdeDTO(EstadoAsociacionDTO dto)
    {
        return EstadoAsociacion.crear(dto.getCodigo(), dto.getNombre());
    }

    @Override
    public EstadoAsociacionDTO ensamblarDTODesdeDominio(EstadoAsociacion dominio)
    {
        return new EstadoAsociacionDTO(dominio.getCodigo(), dominio.getNombre());
    }

    @Override
    public EstadoAsociacionEntidad ensamblarEntidadDesdeDominioParaGuardar(int codigo, EstadoEntidad estado)
    {
        return new EstadoAsociacionEntidad(codigo, estado);
    }
}