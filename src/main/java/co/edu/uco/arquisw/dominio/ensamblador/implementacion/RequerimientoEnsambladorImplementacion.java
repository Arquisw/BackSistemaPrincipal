package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.RequerimientoDTO;
import co.edu.uco.arquisw.dominio.ensamblador.RequerimientoEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Requerimiento;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.RequerimientoEntidad;

public class RequerimientoEnsambladorImplementacion implements RequerimientoEnsamblador
{
    private static final RequerimientoEnsamblador INSTANCE = new RequerimientoEnsambladorImplementacion();

    private RequerimientoEnsambladorImplementacion()
    {

    }

    public static RequerimientoEnsamblador obtenerRequerimientoEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Requerimiento ensamblarDominioDesdeEntidad(RequerimientoEntidad entidad)
    {
        return null;
    }

    @Override
    public RequerimientoEntidad ensamblarEntidadDesdeDominio(Requerimiento dominio)
    {
        return null;
    }

    @Override
    public Requerimiento ensamblarDominioDesdeDTO(RequerimientoDTO dto)
    {
        return null;
    }

    @Override
    public RequerimientoDTO ensamblarDTODesdeDominio(Requerimiento dominio)
    {
        return null;
    }
}