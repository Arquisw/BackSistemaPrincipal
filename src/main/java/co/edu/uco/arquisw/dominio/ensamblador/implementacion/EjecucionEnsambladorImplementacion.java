package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.EjecucionDTO;
import co.edu.uco.arquisw.dominio.ensamblador.EjecucionEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Ejecucion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EjecucionEntidad;

public class EjecucionEnsambladorImplementacion implements EjecucionEnsamblador
{
    private static final EjecucionEnsamblador INSTANCE = new EjecucionEnsambladorImplementacion();

    private EjecucionEnsambladorImplementacion()
    {

    }

    public static EjecucionEnsamblador obtenerEjecucionEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Ejecucion ensamblarDominioDesdeEntidad(EjecucionEntidad entidad)
    {
        return null;
    }

    @Override
    public EjecucionEntidad ensamblarEntidadDesdeDominio(Ejecucion dominio)
    {
        return null;
    }

    @Override
    public Ejecucion ensamblarDominioDesdeDTO(EjecucionDTO dto)
    {
        return null;
    }

    @Override
    public EjecucionDTO ensamblarDTODesdeDominio(Ejecucion dominio)
    {
        return null;
    }
}
