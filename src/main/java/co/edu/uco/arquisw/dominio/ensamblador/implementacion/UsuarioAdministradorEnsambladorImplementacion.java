package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioAdministradorDTO;
import co.edu.uco.arquisw.dominio.ensamblador.UsuarioAdministradorEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.UsuarioAdministrador;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioAdministradorEntidad;

public class UsuarioAdministradorEnsambladorImplementacion implements UsuarioAdministradorEnsamblador
{
    private static final UsuarioAdministradorEnsamblador INSTANCE = new UsuarioAdministradorEnsambladorImplementacion();

    private UsuarioAdministradorEnsambladorImplementacion()
    {

    }

    public static UsuarioAdministradorEnsamblador obtenerUsuarioAdministradorEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public UsuarioAdministrador ensamblarDominioDesdeEntidad(UsuarioAdministradorEntidad entidad)
    {
        return null;
    }

    @Override
    public UsuarioAdministradorEntidad ensamblarEntidadDesdeDominio(UsuarioAdministrador dominio)
    {
        return null;
    }

    @Override
    public UsuarioAdministrador ensamblarDominioDesdeDTO(UsuarioAdministradorDTO dto)
    {
        return null;
    }

    @Override
    public UsuarioAdministradorDTO ensamblarDTODesdeDominio(UsuarioAdministrador dominio)
    {
        return null;
    }
}