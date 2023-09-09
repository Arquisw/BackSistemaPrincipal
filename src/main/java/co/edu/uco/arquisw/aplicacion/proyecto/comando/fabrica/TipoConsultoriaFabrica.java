package co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.TipoConsultoriaComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.TipoConsultoria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoConsultoriaFabrica {
    public TipoConsultoria construir(TipoConsultoriaComando tipoConsultoria) {
        return TipoConsultoria.crear(tipoConsultoria.getNombre());
    }

    public List<TipoConsultoria> construirTodos(List<TipoConsultoriaComando> tiposConsultoria) {
        return tiposConsultoria.stream().map(new TipoConsultoriaFabrica()::construir).toList();
    }
}