package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioPostulacionDTO;
import co.edu.uco.arquisw.dominio.ensamblador.UsuarioPostulacionEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.UsuarioPostulacion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioPostulacionEntidad;

public class UsuarioPostulacionEnsambladorImplementacion implements UsuarioPostulacionEnsamblador
{
    private static final UsuarioPostulacionEnsamblador INSTANCE = new UsuarioPostulacionEnsambladorImplementacion();

    private UsuarioPostulacionEnsambladorImplementacion()
    {

    }

    public static UsuarioPostulacionEnsamblador obtenerUsuarioPostulacionEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public UsuarioPostulacion ensamblarDominioDesdeEntidad(UsuarioPostulacionEntidad entidad)
    {
        return null;
    }

    @Override
    public UsuarioPostulacionEntidad ensamblarEntidadDesdeDominio(UsuarioPostulacion dominio)
    {
        return null;
    }

    @Override
    public UsuarioPostulacion ensamblarDominioDesdeDTO(UsuarioPostulacionDTO dto)
    {
        return null;
    }

    @Override
    public UsuarioPostulacionDTO ensamblarDTODesdeDominio(UsuarioPostulacion dominio)
    {
        return null;
    }
}