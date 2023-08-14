package co.edu.uco.arquisw.aplicacion.postulacion.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.MotivoRechazoPostulacionComando;
import co.edu.uco.arquisw.dominio.postulacion.modelo.MotivoRechazoPostulacion;
import org.springframework.stereotype.Component;

@Component
public class MotivoRechazoPostulacionFabrica {
    public MotivoRechazoPostulacion construir(MotivoRechazoPostulacionComando motivoRechazoPostulacionComando) {
        return MotivoRechazoPostulacion.crear(motivoRechazoPostulacionComando.getMotivoRechazo());
    }
}
