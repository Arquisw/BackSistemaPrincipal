package co.edu.uco.arquisw.dominio.usuario.puerto.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonaRepositorioConsulta {
    PersonaDTO consultarPorId(Long id);

    UsuarioDTO consultarUsuarioPorId(Long id);

    UsuarioDTO consultarUsuarioPorCorreo(String correo);

    PersonaDTO consultarPorCorreo(String correo);

    boolean existeConCorreo(String correo);

    HojaDeVidaPersonaDTO consultarHojaDeVidaPorIdUsuario(Long usuarioID);

    List<PeticionEliminacionPersonaDTO> consultarPeticionesDeEliminacionDeUsuarios();

    Page<PeticionEliminacionPersonaDTO> consultarPeticionesDeEliminacionDeUsuariosPaginado(int pagin, int tamano);

    String consultarClaveConCorreo(String correo);

    String consultarCodigoConCorreo(String correo);

    String consultarCodigoActivacionCuentaConCorreo(String correo);

    PeticionRecuperacionClaveDTO consultarPeticionRecuperacionClaveDTOConCorreo(String correo);

    List<RolDTO> consultarRolesPorAdministrador();

    RolDTO consultarRolPorId(Long id);

    PeticionActivacionCuentaDTO consultarPeticionActivacionCuentaConCorreo(String correo);
}