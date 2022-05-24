package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.FaseDetalladaDTO;
import co.edu.uco.arquisw.dominio.ensamblador.FaseDetalladaEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.FaseDetallada;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.FaseDetalladaEntidad;

public class FaseDetalladaEnsambladorImplementacion implements FaseDetalladaEnsamblador
{
    private static final FaseDetalladaEnsamblador INSTANCE = new FaseDetalladaEnsambladorImplementacion();

    private FaseDetalladaEnsambladorImplementacion()
    {

    }

    public static FaseDetalladaEnsamblador obtenerFaseDetalladaEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public FaseDetallada ensamblarDominioDesdeEntidad(FaseDetalladaEntidad entidad)
    {
        return null;
    }

    @Override
    public FaseDetalladaEntidad ensamblarEntidadDesdeDominio(FaseDetallada dominio)
    {
        return null;
    }

    @Override
    public FaseDetallada ensamblarDominioDesdeDTO(FaseDetalladaDTO dto)
    {
        return null;
    }

    @Override
    public FaseDetalladaDTO ensamblarDTODesdeDominio(FaseDetallada dominio)
    {
        return null;
    }
}