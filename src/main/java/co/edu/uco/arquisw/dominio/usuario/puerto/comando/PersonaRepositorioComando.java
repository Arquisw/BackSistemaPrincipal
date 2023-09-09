package co.edu.uco.arquisw.dominio.usuario.puerto.comando;

import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;

public interface PersonaRepositorioComando {
    Long guardar(Persona persona, Usuario usuario, String clave);

    Long actualizar(Persona persona, Long id);

    Long actualizarClave(String claveNueva, Long id);

    void crearRol(Rol rol, Long id);

    void eliminarRolAsociacion(Rol rol, Long id);

    void eliminarRol(Rol rol, Long id);

    void eliminar(Long id);

    void eliminarPorAdminsitrador(Long id);

    Long guardarHojaDeVida(HojaDeVidaPersona hojaDeVida, Long usuarioId);

    Long actualizarHojaDeVida(HojaDeVidaPersona hojaDeVida, Long usuarioId);

    void crearNotificacionEliminacion(Long id);

    Long crearPeticionRecuperacionClave(String codigo, String correo, String fecha);

    void eliminarPeticionRecuperacionClave(Long id);

    Long actualizarRol(boolean leer, boolean escribir, boolean actualizar, boolean eliminar, Long id);
}