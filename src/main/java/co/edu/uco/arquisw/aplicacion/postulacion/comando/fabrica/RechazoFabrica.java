package co.edu.uco.arquisw.aplicacion.postulacion.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.RechazoComando;
import co.edu.uco.arquisw.dominio.postulacion.modelo.MotivoRechazoPostulacion;
import org.springframework.stereotype.Component;

@Component
public class RechazoFabrica {
    public MotivoRechazoPostulacion construir(RechazoComando rechazoComando) {
        return MotivoRechazoPostulacion.crear(rechazoComando.getMotivoRechazo());
    }
}
