package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.HojaDeVidaPersonaEntidad;
import org.springframework.stereotype.Component;

@Component
public class HojaDeVidaPersonaMapeador {
    public HojaDeVidaPersonaDTO construirDTO(HojaDeVidaPersonaEntidad hojaDeVida) {
        return new HojaDeVidaPersonaDTO(hojaDeVida.getId(), hojaDeVida.getRuta());
    }

    public HojaDeVidaPersonaEntidad construirEntidad(HojaDeVidaPersona hojaDeVidaPersona, Long id) {
        return new HojaDeVidaPersonaEntidad(NumeroConstante.CERO, hojaDeVidaPersona.getRutaArchivo(), id);
    }

    public void actualizarEntidad(HojaDeVidaPersonaEntidad hojaDeVidaPersonaEntidad, HojaDeVidaPersona hojaDeVidaPersona) {
        hojaDeVidaPersonaEntidad.setRuta(hojaDeVidaPersona.getRutaArchivo());
    }
}