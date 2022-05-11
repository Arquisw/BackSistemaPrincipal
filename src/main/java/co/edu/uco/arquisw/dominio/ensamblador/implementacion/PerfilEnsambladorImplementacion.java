package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.PerfilDTO;
import co.edu.uco.arquisw.dominio.dto.PerfilResumenDTO;
import co.edu.uco.arquisw.dominio.ensamblador.PerfilEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PerfilEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PerfilUsuarioEntidad;

import java.util.List;

public class PerfilEnsambladorImplementacion implements PerfilEnsamblador
{
    private static final PerfilEnsamblador INSTANCE = new PerfilEnsambladorImplementacion();

    private PerfilEnsambladorImplementacion()
    {

    }

    public static PerfilEnsamblador obtenerPerfilEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Perfil ensamblarDominioDesdeEntidad(PerfilUsuarioEntidad entidad)
    {
        return Perfil.crear(entidad.getCodigo(), entidad.getPerfil().getNombre());
    }

    @Override
    public PerfilUsuarioEntidad ensamblarEntidadDesdeDominio(Perfil dominio)
    {
        int code = 1;

        if(dominio.getNombre().equals("ROLE_ADMIN"))
        {
            code = 2;
        }

        return new PerfilUsuarioEntidad(dominio.getCodigo(), new PerfilEntidad(code, dominio.getNombre()));
    }

    @Override
    public Perfil ensamblarDominioDesdeDTO(PerfilDTO dto)
    {
        return Perfil.crear(dto.getCodigo(), dto.getNombre());
    }

    @Override
    public PerfilDTO ensamblarDTODesdeDominio(Perfil dominio)
    {
        return new PerfilDTO(dominio.getCodigo(), dominio.getNombre());
    }

    @Override
    public PerfilResumenDTO ensamblarResumenDTODesdeEntidad(PerfilUsuarioEntidad entidad)
    {
        return new PerfilResumenDTO(entidad.getCodigo(), entidad.getPerfil().getNombre());
    }

    @Override
    public PerfilUsuarioEntidad ensamblarEntidadDesdeDominioParaGuardar(int codigo, PerfilEntidad perfil)
    {
        return new PerfilUsuarioEntidad(codigo, perfil);
    }

    @Override
    public List<Perfil> ensamblarDominiosDesdeEntidades(List<PerfilUsuarioEntidad> entidades)
    {
        return entidades.stream().map(obtenerPerfilEnsamblador()::ensamblarDominioDesdeEntidad).toList();
    }

    @Override
    public List<PerfilUsuarioEntidad> ensamblarEntidadesDesdeDominios(List<Perfil> dominios)
    {
        return dominios.stream().map(obtenerPerfilEnsamblador()::ensamblarEntidadDesdeDominio).toList();
    }

    @Override
    public List<PerfilDTO> ensamblarDTOsDesdeDominios(List<Perfil> dominios)
    {
        return dominios.stream().map(obtenerPerfilEnsamblador()::ensamblarDTODesdeDominio).toList();
    }

    @Override
    public List<Perfil> ensamblarDominiosDesdeDTOs(List<PerfilDTO> dtos)
    {
        return dtos.stream().map(obtenerPerfilEnsamblador()::ensamblarDominioDesdeDTO).toList();
    }

    @Override
    public List<PerfilResumenDTO> ensamblarResumenesDTODesdeEntidades(List<PerfilUsuarioEntidad> entidades)
    {
        return entidades.stream().map(obtenerPerfilEnsamblador()::ensamblarResumenDTODesdeEntidad).toList();
    }
}