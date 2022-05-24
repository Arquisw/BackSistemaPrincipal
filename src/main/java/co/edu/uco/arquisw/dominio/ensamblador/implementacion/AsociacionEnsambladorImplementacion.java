package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.ensamblador.AsociacionEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Asociacion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.AsociacionEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoAsociacionEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.NecesidadEntidad;

import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.EstadoAsociacionEnsambladorImplementacion.obtenerEstadoAsociacionEnsamblador;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.NecesidadEnsambladorImplementacion.obtenerNecesidadEnsamblador;

public class AsociacionEnsambladorImplementacion implements AsociacionEnsamblador
{
    private static final AsociacionEnsamblador INSTANCE = new AsociacionEnsambladorImplementacion();

    private AsociacionEnsambladorImplementacion()
    {

    }

    public static AsociacionEnsamblador obtenerAsociacionEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Asociacion ensamblarDominioDesdeEntidad(AsociacionEntidad entidad)
    {
        return Asociacion.crear(entidad.getCodigo(), entidad.getNit(), entidad.getNombre(), obtenerEstadoAsociacionEnsamblador().ensamblarDominioDesdeEntidad(entidad.getEstado()), obtenerNecesidadEnsamblador().ensamblarDominioDesdeEntidad(entidad.getNecesidad()));
    }

    @Override
    public AsociacionEntidad ensamblarEntidadDesdeDominio(Asociacion dominio)
    {
        return new AsociacionEntidad(dominio.getCodigo(), dominio.getNit(), dominio.getNombre(), obtenerEstadoAsociacionEnsamblador().ensamblarEntidadDesdeDominio(dominio.getEstado()), obtenerNecesidadEnsamblador().ensamblarEntidadDesdeDominio(dominio.getNecesidad()));
    }

    @Override
    public Asociacion ensamblarDominioDesdeDTO(AsociacionDTO dto)
    {
        return Asociacion.crear(dto.getCodigo(), dto.getNit(), dto.getNombre(), obtenerEstadoAsociacionEnsamblador().ensamblarDominioDesdeDTO(dto.getEstado()), obtenerNecesidadEnsamblador().ensamblarDominioDesdeDTO(dto.getNecesidad()));
    }

    @Override
    public AsociacionDTO ensamblarDTODesdeDominio(Asociacion dominio)
    {
        return new AsociacionDTO(dominio.getCodigo(), dominio.getNit(), dominio.getNombre(), obtenerEstadoAsociacionEnsamblador().ensamblarDTODesdeDominio(dominio.getEstado()), obtenerNecesidadEnsamblador().ensamblarDTODesdeDominio(dominio.getNecesidad()));
    }

    @Override
    public AsociacionEntidad ensamblarEntidadDesdeDominioParaGuardar(Asociacion dominio, EstadoAsociacionEntidad estado)
    {
        return new AsociacionEntidad(dominio.getCodigo(), dominio.getNit(), dominio.getNombre(), estado, new NecesidadEntidad());
    }
}