package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.RolDTO;
import co.edu.uco.arquisw.dominio.ensamblador.RolEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Rol;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.RolEntidad;

public class RolEnsambladorImplementacion implements RolEnsamblador
{
    private static final RolEnsamblador INSTANCE = new RolEnsambladorImplementacion();

    private RolEnsambladorImplementacion()
    {

    }

    public static RolEnsamblador obtenerRolEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Rol ensamblarDominioDesdeEntidad(RolEntidad entidad)
    {
        return null;
    }

    @Override
    public RolEntidad ensamblarEntidadDesdeDominio(Rol dominio)
    {
        return null;
    }

    @Override
    public Rol ensamblarDominioDesdeDTO(RolDTO dto)
    {
        return null;
    }

    @Override
    public RolDTO ensamblarDTODesdeDominio(Rol dominio)
    {
        return null;
    }
}