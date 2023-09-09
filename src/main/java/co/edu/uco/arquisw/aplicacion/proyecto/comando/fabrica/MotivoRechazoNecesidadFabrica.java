package co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.MotivoRechazoNecesidadComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.MotivoRechazoNecesidad;
import org.springframework.stereotype.Component;

@Component
public class MotivoRechazoNecesidadFabrica {
    public MotivoRechazoNecesidad construir(MotivoRechazoNecesidadComando motivoRechazoNecesidadComando) {
        return MotivoRechazoNecesidad.crear(motivoRechazoNecesidadComando.getMotivoRechazo());
    }
}