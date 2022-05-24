package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.FaseEjecucionDTO;
import co.edu.uco.arquisw.dominio.ensamblador.FaseEjecucionEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.FaseEjecucion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.FaseEjecucionEntidad;

public class FaseEjecucionEnsambladorImplementacion implements FaseEjecucionEnsamblador
{
    private static final FaseEjecucionEnsamblador INSTANCE = new FaseEjecucionEnsambladorImplementacion();

    private FaseEjecucionEnsambladorImplementacion()
    {

    }

    public static FaseEjecucionEnsamblador obtenerFaseEjecucionEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public FaseEjecucion ensamblarDominioDesdeEntidad(FaseEjecucionEntidad entidad)
    {
        return null;
    }

    @Override
    public FaseEjecucionEntidad ensamblarEntidadDesdeDominio(FaseEjecucion dominio)
    {
        return null;
    }

    @Override
    public FaseEjecucion ensamblarDominioDesdeDTO(FaseEjecucionDTO dto)
    {
        return null;
    }

    @Override
    public FaseEjecucionDTO ensamblarDTODesdeDominio(FaseEjecucion dominio)
    {
        return null;
    }
}