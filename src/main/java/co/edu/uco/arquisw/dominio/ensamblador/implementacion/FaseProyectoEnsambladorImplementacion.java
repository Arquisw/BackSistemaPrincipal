package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.FaseProyectoDTO;
import co.edu.uco.arquisw.dominio.ensamblador.FaseProyectoEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.FaseProyecto;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.FaseProyectoEntidad;

public class FaseProyectoEnsambladorImplementacion implements FaseProyectoEnsamblador
{
    private static final FaseProyectoEnsamblador INSTANCE = new FaseProyectoEnsambladorImplementacion();

    private FaseProyectoEnsambladorImplementacion()
    {

    }

    public static FaseProyectoEnsamblador obtenerFaseProyectoEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public FaseProyecto ensamblarDominioDesdeEntidad(FaseProyectoEntidad entidad)
    {
        return null;
    }

    @Override
    public FaseProyectoEntidad ensamblarEntidadDesdeDominio(FaseProyecto dominio)
    {
        return null;
    }

    @Override
    public FaseProyecto ensamblarDominioDesdeDTO(FaseProyectoDTO dto)
    {
        return null;
    }

    @Override
    public FaseProyectoDTO ensamblarDTODesdeDominio(FaseProyecto dominio)
    {
        return null;
    }
}