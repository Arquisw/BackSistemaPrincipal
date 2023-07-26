package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.usuario.dto.PeticionRecuperacionClaveDTO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionRecuperacionClaveEntidad;
import org.springframework.stereotype.Component;

@Component
public class PeticionRecuperacionClaveMapeador {
    public PeticionRecuperacionClaveEntidad construirEntidad(String codigo, String correo, String fecha) {
        return new PeticionRecuperacionClaveEntidad(0L, codigo, correo, fecha);
    }

    public void actualizarEntidad(PeticionRecuperacionClaveEntidad entidad, String codigo, String fecha) {
        entidad.setCodigo(codigo);
        entidad.setFecha(fecha);
    }

    public PeticionRecuperacionClaveDTO construirDTO(PeticionRecuperacionClaveEntidad entidad) {
        return new PeticionRecuperacionClaveDTO(entidad.getId(), entidad.getCorreo(), entidad.getCodigo(), FechaFormateador.obtenerFechaTiempo(entidad.getFecha()));
    }
}
