package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
import co.edu.uco.arquisw.dominio.ensamblador.UsuarioEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioEntidad;
import java.util.List;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.PerfilEnsambladorImplementacion.obtenerPerfilEnsamblador;

public class UsuarioEnsambladorImplementacion implements UsuarioEnsamblador
{
    private static final UsuarioEnsamblador INSTANCE = new UsuarioEnsambladorImplementacion();

    private UsuarioEnsambladorImplementacion()
    {

    }

    public static UsuarioEnsamblador obtenerUsuarioEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Usuario ensamblarDominioDesdeEntidad(UsuarioEntidad entidad)
    {
        return Usuario.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getApellidos(), entidad.getNumeroIdentificacion(), entidad.getCorreo(), entidad.getClave(), entidad.getInstitucion(), obtenerPerfilEnsamblador().ensamblarDominiosDesdeEntidades(entidad.getPerfiles()));
    }

    @Override
    public UsuarioEntidad ensamblarEntidadDesdeDominio(Usuario dominio)
    {
        return new UsuarioEntidad(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getNumeroIdentificacion(), dominio.getCorreo(), dominio.getClave(), dominio.getInstitucion(), obtenerPerfilEnsamblador().ensamblarEntidadesDesdeDominios(dominio.getPerfiles()));
    }

    @Override
    public Usuario ensamblarDominioDesdeDTO(UsuarioDTO dto)
    {
        return Usuario.crear(dto.getCodigo(), dto.getNombre(), dto.getApellidos(), dto.getNumeroIdentificacion(), dto.getCorreo(), dto.getClave(), dto.getInstitucion(), obtenerPerfilEnsamblador().ensamblarDominiosDesdeDTOs(dto.getPerfiles()));
    }

    @Override
    public UsuarioDTO ensamblarDTODesdeDominio(Usuario dominio)
    {
        return new UsuarioDTO(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getNumeroIdentificacion(), dominio.getCorreo(), dominio.getClave(), dominio.getInstitucion(), obtenerPerfilEnsamblador().ensamblarDTOsDesdeDominios(dominio.getPerfiles()));
    }

    @Override
    public UsuarioResumenDTO ensamblarResumenDTODesdeEntidad(UsuarioEntidad entidad)
    {
        return new UsuarioResumenDTO(entidad.getCodigo(), entidad.getNombre(), entidad.getApellidos(), entidad.getNumeroIdentificacion(), entidad.getCorreo(), entidad.getInstitucion(), obtenerPerfilEnsamblador().ensamblarResumenesDTODesdeEntidades(entidad.getPerfiles()));
    }

    @Override
    public Usuario ensamblarDominioDesdeDominioParaModificar(Usuario usuario, List<Perfil> perfiles)
    {
        return Usuario.crear(usuario.getCodigo(), usuario.getNombre(), usuario.getApellidos(), usuario.getNumeroIdentificacion(), usuario.getCorreo(), usuario.getClave(), usuario.getInstitucion(), perfiles);
    }

    @Override
    public List<Usuario> ensamblarDominiosDesdeEntidades(List<UsuarioEntidad> entidades)
    {
        return entidades.stream().map(obtenerUsuarioEnsamblador()::ensamblarDominioDesdeEntidad).toList();
    }

    @Override
    public List<UsuarioEntidad> ensamblarEntidadesDesdeDominios(List<Usuario> dominios)
    {
        return dominios.stream().map(obtenerUsuarioEnsamblador()::ensamblarEntidadDesdeDominio).toList();
    }

    @Override
    public List<UsuarioDTO> ensamblarDTOsDesdeDominios(List<Usuario> dominios)
    {
        return dominios.stream().map(obtenerUsuarioEnsamblador()::ensamblarDTODesdeDominio).toList();
    }

    @Override
    public List<Usuario> ensamblarDominiosDesdeDTOs(List<UsuarioDTO> dtos)
    {
        return dtos.stream().map(obtenerUsuarioEnsamblador()::ensamblarDominioDesdeDTO).toList();
    }

    @Override
    public List<UsuarioResumenDTO> ensamblarResumenesDTODesdeEntidades(List<UsuarioEntidad> entidades)
    {
        return entidades.stream().map(obtenerUsuarioEnsamblador()::ensamblarResumenDTODesdeEntidad).toList();
    }
}