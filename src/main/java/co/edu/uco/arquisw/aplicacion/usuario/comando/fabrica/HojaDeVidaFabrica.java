package co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.usuario.comando.HojaVidaComando;
import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.springframework.stereotype.Component;

@Component
public class HojaDeVidaFabrica
{
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public HojaDeVidaFabrica(PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public HojaDeVidaPersona construir(HojaVidaComando hojaVida)
    {
        return HojaDeVidaPersona.crear(hojaVida.getRuta());
    }
    public HojaDeVidaPersona construirActualizar(HojaVidaComando hojaVida, Long id)
    {
        return HojaDeVidaPersona.crear(hojaVida.getRuta());
    }
}
