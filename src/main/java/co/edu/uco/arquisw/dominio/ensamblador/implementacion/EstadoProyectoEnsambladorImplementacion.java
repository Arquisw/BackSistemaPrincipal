package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.EstadoProyectoDTO;
import co.edu.uco.arquisw.dominio.ensamblador.EstadoProyectoEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.EstadoProyecto;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoProyectoEntidad;

public class EstadoProyectoEnsambladorImplementacion implements EstadoProyectoEnsamblador
{
    private static final EstadoProyectoEnsamblador INSTANCE = new EstadoProyectoEnsambladorImplementacion();

    private EstadoProyectoEnsambladorImplementacion()
    {

    }

    public static EstadoProyectoEnsamblador obtenerEstadoProyectoEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public EstadoProyecto ensamblarDominioDesdeEntidad(EstadoProyectoEntidad entidad)
    {
        return null;
    }

    @Override
    public EstadoProyectoEntidad ensamblarEntidadDesdeDominio(EstadoProyecto dominio)
    {
        return null;
    }

    @Override
    public EstadoProyecto ensamblarDominioDesdeDTO(EstadoProyectoDTO dto)
    {
        return null;
    }

    @Override
    public EstadoProyectoDTO ensamblarDTODesdeDominio(EstadoProyecto dominio)
    {
        return null;
    }
}