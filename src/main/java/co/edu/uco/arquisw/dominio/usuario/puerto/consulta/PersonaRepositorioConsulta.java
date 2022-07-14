package co.edu.uco.arquisw.dominio.usuario.puerto.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PeticionEliminacionDTO;

import java.util.List;

public interface PersonaRepositorioConsulta
{
    PersonaDTO consultarPorId(Long id);
    PersonaDTO consultarPorCorreo(String correo);
    boolean existeConCorreo(String correo);
    HojaDeVidaPersonaDTO consultarHojaDeVidaPorIdUsuario(Long usuarioID);
    List<PeticionEliminacionDTO> consultarPeticionesDeEliminacionDeUsuarios();
}