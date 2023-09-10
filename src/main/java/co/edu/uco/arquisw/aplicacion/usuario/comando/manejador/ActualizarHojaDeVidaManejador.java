package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoVariableDeRutaRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.HojaVidaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica.HojaDeVidaFabrica;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioActualizarHojaDeVida;
import org.springframework.stereotype.Component;

@Component
public class ActualizarHojaDeVidaManejador implements ManejadorComandoVariableDeRutaRespuesta<HojaVidaComando, Long, ComandoRespuesta<Long>> {
     private final ServicioActualizarHojaDeVida servicioActualizarHojaDeVida;
     private final HojaDeVidaFabrica hojaDeVidaFabrica;
     public ActualizarHojaDeVidaManejador(ServicioActualizarHojaDeVida servicioActualizarHojaDeVida, HojaDeVidaFabrica hojaDeVidaFabrica) {
        this.servicioActualizarHojaDeVida = servicioActualizarHojaDeVida;
        this.hojaDeVidaFabrica = hojaDeVidaFabrica;
     }

     @Override
     public ComandoRespuesta<Long> ejecutar(HojaVidaComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioActualizarHojaDeVida.ejecutar(this.hojaDeVidaFabrica.construir(comando), id));
     }
}