package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.postulacion.modelo.MotivoRechazoPostulacion;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.MotivoRechazoPostulacionEntidad;
import org.springframework.stereotype.Component;

@Component
public class MotivoRechazoPostulacionMapeador {
    public MotivoRechazoPostulacionEntidad construir(MotivoRechazoPostulacion motivoRechazoPostulacion, Long postulacionId) {
        return new MotivoRechazoPostulacionEntidad(0L, motivoRechazoPostulacion.getMotivo(), postulacionId);
    }
}