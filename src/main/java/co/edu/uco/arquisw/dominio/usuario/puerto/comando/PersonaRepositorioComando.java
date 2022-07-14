package co.edu.uco.arquisw.dominio.usuario.puerto.comando;

import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;

public interface PersonaRepositorioComando
{
    Long guardar(Persona persona);
    Long actualizar(Persona persona, Long id);
    void eliminar(Long id);
    void eliminarPorAdministrador(Long id);
    Long guardarHojadeVida(HojaDeVidaPersona hojaDeVida);
    Long actualizarHojadeVida(HojaDeVidaPersona hojaDeVida);

}