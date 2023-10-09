package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.proyecto.modelo.MotivoRechazoNecesidad;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.MotivoRechazoNecesidadEntidad;
import org.springframework.stereotype.Component;

@Component
public class MotivoRechazoNecesidadMapeador {
    public MotivoRechazoNecesidadEntidad construirEntidad(MotivoRechazoNecesidad motivoRechazoNecesidad, Long necesidadId) {
        return new MotivoRechazoNecesidadEntidad(NumeroConstante.CERO, motivoRechazoNecesidad.getMotivo(), necesidadId);
    }
}