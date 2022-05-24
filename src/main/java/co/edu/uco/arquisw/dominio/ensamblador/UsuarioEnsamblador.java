package co.edu.uco.arquisw.dominio.ensamblador;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioEntidad;
import java.util.List;

public interface UsuarioEnsamblador extends Ensamblador<Usuario, UsuarioEntidad, UsuarioDTO>
{
    UsuarioResumenDTO ensamblarResumenDTODesdeEntidad(UsuarioEntidad entidad);
    Usuario ensamblarDominioDesdeDominioParaModificar(Usuario usuario, List<Perfil> perfiles);
    List<Usuario> ensamblarDominiosDesdeEntidades(List<UsuarioEntidad> entidades);
    List<UsuarioEntidad> ensamblarEntidadesDesdeDominios(List<Usuario> dominios);
    List<UsuarioDTO> ensamblarDTOsDesdeDominios(List<Usuario> dominios);
    List<Usuario> ensamblarDominiosDesdeDTOs(List<UsuarioDTO> dtos);
    List<UsuarioResumenDTO> ensamblarResumenesDTODesdeEntidades(List<UsuarioEntidad> entidades);
}