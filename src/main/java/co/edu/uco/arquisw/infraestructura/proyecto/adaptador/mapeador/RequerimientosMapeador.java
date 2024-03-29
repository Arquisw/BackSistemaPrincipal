package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.dto.RequerimientosDTO;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Requerimientos;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.RequerimientoArchivoEntidad;
import org.springframework.stereotype.Component;

@Component
public class RequerimientosMapeador {
    public RequerimientoArchivoEntidad construirEntidad(Requerimientos requerimientos, Long necesidadId) {
        return new RequerimientoArchivoEntidad(NumeroConstante.CERO, requerimientos.getRutaArchivo(), necesidadId);
    }

    public RequerimientosDTO construirDTO(RequerimientoArchivoEntidad requerimientoArchivoEntidad) {
        return new RequerimientosDTO(NumeroConstante.CERO, requerimientoArchivoEntidad.getRuta());
    }
}