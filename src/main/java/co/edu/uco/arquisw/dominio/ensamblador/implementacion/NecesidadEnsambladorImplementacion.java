package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.ensamblador.NecesidadEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Necesidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.NecesidadEntidad;

public class NecesidadEnsambladorImplementacion implements NecesidadEnsamblador
{
    private static final NecesidadEnsamblador INSTANCE = new NecesidadEnsambladorImplementacion();

    private NecesidadEnsambladorImplementacion()
    {

    }

    public static NecesidadEnsamblador obtenerNecesidadEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Necesidad ensamblarDominioDesdeEntidad(NecesidadEntidad entidad)
    {
        return null;
    }

    @Override
    public NecesidadEntidad ensamblarEntidadDesdeDominio(Necesidad dominio)
    {
        return null;
    }

    @Override
    public Necesidad ensamblarDominioDesdeDTO(NecesidadDTO dto)
    {
        return null;
    }

    @Override
    public NecesidadDTO ensamblarDTODesdeDominio(Necesidad dominio)
    {
        return null;
    }
}