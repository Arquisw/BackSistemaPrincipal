package co.edu.uco.arquisw.dominio.usuario.puerto.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonDto;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;

public interface PersonaRepositorioConsulta
{
    PersonaDTO consultarPorId(Long id);
    PersonaDTO consultarPorCorreo(String correo);
    boolean existeConCorreo(String correo);
    PersonaDTO consultarPostulados(Long proyectoID);
    PersonaDTO consultarSeleccionados(Long proyectoID);
    HojaDeVidaPersonDto consultarHojaDeVidaPorIdUsuario(Long usuarioID);
}