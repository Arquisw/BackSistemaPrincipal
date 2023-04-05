package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.HojaVidaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica.HojaDeVidaFabrica;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioGuardarHojaDeVida;
import org.springframework.stereotype.Component;

@Component
public class GuardarHojaDeVidaManejador implements ManejadorComandoActualizacionRespuesta<HojaVidaComando,Long, ComandoRespuesta<Long>> {
    private final ServicioGuardarHojaDeVida servicioGuardarHojaDeVida;
    private final HojaDeVidaFabrica hojaDeVidaFabrica;

    public GuardarHojaDeVidaManejador(ServicioGuardarHojaDeVida servicioGuardarHojaDeVida, HojaDeVidaFabrica hojaDeVidaFabrica) {
        this.servicioGuardarHojaDeVida = servicioGuardarHojaDeVida;
        this.hojaDeVidaFabrica = hojaDeVidaFabrica;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(HojaVidaComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioGuardarHojaDeVida.ejecutar(this.hojaDeVidaFabrica.construir(comando),id));
    }
}