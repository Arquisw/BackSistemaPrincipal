package co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.RequerimientosComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Requerimientos;
import org.springframework.stereotype.Component;

@Component
public class RequerimientosFabrica {
    public Requerimientos construir(RequerimientosComando requerimientos) {
        return Requerimientos.crear(requerimientos.getRutaArchivo());
    }
}