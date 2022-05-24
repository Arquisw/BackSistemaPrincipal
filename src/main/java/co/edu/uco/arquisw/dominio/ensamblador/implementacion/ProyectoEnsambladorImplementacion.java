package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.ensamblador.ProyectoEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Proyecto;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.ProyectoEntidad;

public class ProyectoEnsambladorImplementacion implements ProyectoEnsamblador
{
    private static final ProyectoEnsamblador INSTANCE = new ProyectoEnsambladorImplementacion();

    private ProyectoEnsambladorImplementacion()
    {

    }

    public static ProyectoEnsamblador obtenerProyectoEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Proyecto ensamblarDominioDesdeEntidad(ProyectoEntidad entidad)
    {
        return null;
    }

    @Override
    public ProyectoEntidad ensamblarEntidadDesdeDominio(Proyecto dominio)
    {
        return null;
    }

    @Override
    public Proyecto ensamblarDominioDesdeDTO(ProyectoDTO dto)
    {
        return null;
    }

    @Override
    public ProyectoDTO ensamblarDTODesdeDominio(Proyecto dominio)
    {
        return null;
    }
}