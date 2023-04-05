package co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.usuario.comando.HojaVidaComando;
import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import org.springframework.stereotype.Component;

@Component
public class HojaDeVidaFabrica {
    public HojaDeVidaPersona construir(HojaVidaComando hojaVida) {
        return HojaDeVidaPersona.crear(hojaVida.getRuta());
    }
}