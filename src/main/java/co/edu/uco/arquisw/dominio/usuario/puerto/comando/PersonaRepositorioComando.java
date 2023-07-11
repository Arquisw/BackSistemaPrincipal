package co.edu.uco.arquisw.dominio.usuario.puerto.comando;

import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;

public interface PersonaRepositorioComando {
    Long guardar(Persona persona, String clave);
    Long actualizar(Persona persona, Long id);
    Long actualizarClave(String claveNueva, Long id);
    void crearRol(Rol rol, Long id);
    void eliminarRolAsociacion(Rol rol, Long id);
    void eliminarRol(Rol rol, Long id);
    void eliminar(Long id);
    Long guardarHojaDeVida(HojaDeVidaPersona hojaDeVida,Long usuarioId);
    Long actualizarHojaDeVida(HojaDeVidaPersona hojaDeVida,Long usuarioId);
    void crearNotificacionEliminacion(Long id);
}