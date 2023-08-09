package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.entidad.AsociacionEntidad;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AsociacionMapeador {
    public AsociacionDTO construirDTO(AsociacionEntidad asociacion, String nombre) {
        return new AsociacionDTO(asociacion.getId(), asociacion.getNombre(), asociacion.getNit(), asociacion.getNumeroContacto(), nombre);
    }

    public AsociacionEntidad construirEntidad(Asociacion asociacion, Long usuarioID) {
        return new AsociacionEntidad(0L, asociacion.getNombre(), asociacion.getNit(), asociacion.getNumeroContacto(), usuarioID);
    }
}