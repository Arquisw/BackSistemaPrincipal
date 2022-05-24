package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioAsociacionDTO;
import co.edu.uco.arquisw.dominio.ensamblador.UsuarioAsociacionEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.UsuarioAsociacion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioAsociacionEntidad;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.AsociacionEnsambladorImplementacion.obtenerAsociacionEnsamblador;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.UsuarioEnsambladorImplementacion.obtenerUsuarioEnsamblador;

public class UsuarioAsociacionEnsambladorImplementacion implements UsuarioAsociacionEnsamblador
{
    private static final UsuarioAsociacionEnsamblador INSTANCE = new UsuarioAsociacionEnsambladorImplementacion();

    private UsuarioAsociacionEnsambladorImplementacion()
    {

    }

    public static UsuarioAsociacionEnsamblador obtenerUsuarioAsociacionEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public UsuarioAsociacion ensamblarDominioDesdeEntidad(UsuarioAsociacionEntidad entidad)
    {
        return UsuarioAsociacion.crear(entidad.getCodigo(), obtenerUsuarioEnsamblador().ensamblarDominioDesdeEntidad(entidad.getUsuario()), obtenerAsociacionEnsamblador().ensamblarDominioDesdeEntidad(entidad.getAsociacion()));
    }

    @Override
    public UsuarioAsociacionEntidad ensamblarEntidadDesdeDominio(UsuarioAsociacion dominio)
    {
        return null;
    }

    @Override
    public UsuarioAsociacion ensamblarDominioDesdeDTO(UsuarioAsociacionDTO dto)
    {
        return null;
    }

    @Override
    public UsuarioAsociacionDTO ensamblarDTODesdeDominio(UsuarioAsociacion dominio)
    {
        return null;
    }
}