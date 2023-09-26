package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.usuario.dto.PeticionActivacionCuentaDTO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionActivacionCuentaEntidad;
import org.springframework.stereotype.Component;

@Component
public class PeticionActivacionCuentaMapeador {
    public PeticionActivacionCuentaEntidad construirEntidad(String codigo, String correo, String fecha) {
        return new PeticionActivacionCuentaEntidad(0L, codigo, correo, fecha);
    }

    public void actualizarEntidad(PeticionActivacionCuentaEntidad entidad, String codigo, String fecha) {
        entidad.setCodigo(codigo);
        entidad.setFecha(fecha);
    }

    public PeticionActivacionCuentaDTO construirDTO(PeticionActivacionCuentaEntidad entidad) {
        return new PeticionActivacionCuentaDTO(entidad.getId(), entidad.getCorreo(), entidad.getCodigo(), FechaFormateador.obtenerFechaTiempo(entidad.getFecha()));
    }
}
