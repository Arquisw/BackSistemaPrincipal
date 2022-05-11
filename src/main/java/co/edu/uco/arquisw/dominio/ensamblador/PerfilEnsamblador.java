package co.edu.uco.arquisw.dominio.ensamblador;

import co.edu.uco.arquisw.aplicacion.dto.PerfilDTO;
import co.edu.uco.arquisw.dominio.dto.PerfilResumenDTO;
import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PerfilEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PerfilUsuarioEntidad;
import java.util.List;

public interface PerfilEnsamblador extends Ensamblador<Perfil, PerfilUsuarioEntidad, PerfilDTO>
{
    PerfilResumenDTO ensamblarResumenDTODesdeEntidad(PerfilUsuarioEntidad entidad);
    PerfilUsuarioEntidad ensamblarEntidadDesdeDominioParaGuardar(int codigo, PerfilEntidad perfil);
    List<Perfil> ensamblarDominiosDesdeEntidades(List<PerfilUsuarioEntidad> entidades);
    List<PerfilUsuarioEntidad> ensamblarEntidadesDesdeDominios(List<Perfil> dominios);
    List<PerfilDTO> ensamblarDTOsDesdeDominios(List<Perfil> dominios);
    List<Perfil> ensamblarDominiosDesdeDTOs(List<PerfilDTO> dtos);
    List<PerfilResumenDTO> ensamblarResumenesDTODesdeEntidades(List<PerfilUsuarioEntidad> entidades);
}