package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.entidad.AsociacionEntidad;
import org.springframework.stereotype.Component;

@Component
public class AsociacionMapeador {
    public AsociacionDTO construirDTO(AsociacionEntidad asociacion, String nombre) {
        return new AsociacionDTO(asociacion.getId(), asociacion.getNombre(), asociacion.getNit(), asociacion.getNumeroContacto(), nombre, asociacion.getUsuario());
    }

    public AsociacionEntidad construirEntidad(Asociacion asociacion, Long usuarioID) {
        return new AsociacionEntidad(NumeroConstante.CERO, asociacion.getNombre(), asociacion.getNit(), asociacion.getNumeroContacto(), usuarioID);
    }
}