package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.TipoConsultoriaDTO;
import co.edu.uco.arquisw.dominio.ensamblador.TipoConsultoriaEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.TipoConsultoria;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.TipoConsultoriaEntidad;

public class TipoConsultoriaEnsambladorImplementacion implements TipoConsultoriaEnsamblador
{
    private static final TipoConsultoriaEnsamblador INSTANCE = new TipoConsultoriaEnsambladorImplementacion();

    private TipoConsultoriaEnsambladorImplementacion()
    {

    }

    public static TipoConsultoriaEnsamblador obtenerTipoConsultoriaEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public TipoConsultoria ensamblarDominioDesdeEntidad(TipoConsultoriaEntidad entidad)
    {
        return null;
    }

    @Override
    public TipoConsultoriaEntidad ensamblarEntidadDesdeDominio(TipoConsultoria dominio)
    {
        return null;
    }

    @Override
    public TipoConsultoria ensamblarDominioDesdeDTO(TipoConsultoriaDTO dto)
    {
        return null;
    }

    @Override
    public TipoConsultoriaDTO ensamblarDTODesdeDominio(TipoConsultoria dominio)
    {
        return null;
    }
}