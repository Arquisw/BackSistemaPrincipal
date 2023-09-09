package co.edu.uco.arquisw.dominio.usuario.puerto.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.*;

import java.util.List;

public interface PersonaRepositorioConsulta {
    PersonaDTO consultarPorId(Long id);

    UsuarioDTO consultarUsuarioPorId(Long id);

    UsuarioDTO consultarUsuarioPorCorreo(String correo);

    PersonaDTO consultarPorCorreo(String correo);

    boolean existeConCorreo(String correo);

    HojaDeVidaPersonaDTO consultarHojaDeVidaPorIdUsuario(Long usuarioID);

    List<PeticionEliminacionPersonaDTO> consultarPeticionesDeEliminacionDeUsuarios();

    String consultarClaveConCorreo(String correo);

    String consultarCodigoConCorreo(String correo);

    PeticionRecuperacionClaveDTO consultarPeticionRecuperacionClaveDTOConCorreo(String correo);

    List<RolDTO> consultarRolesPorAdministrador();

    RolDTO consultarRolPorId(Long id);
}