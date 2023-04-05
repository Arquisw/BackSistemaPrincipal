package co.edu.uco.arquisw.aplicacion.usuario.consulta;

import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioConsultarHojaDeVidaPorIdUsuario;
import org.springframework.stereotype.Component;

@Component
public class ConsultarHojaDeVidaPorIdUsuarioManejador implements ManejadorComandoRespuesta<Long, HojaDeVidaPersonaDTO> {
    private final ServicioConsultarHojaDeVidaPorIdUsuario servicioConsultarHojaDeVidaPorIdUsuario;

    public ConsultarHojaDeVidaPorIdUsuarioManejador(ServicioConsultarHojaDeVidaPorIdUsuario servicioConsultarHojaDeVidaPorIdUsuario) {
        this.servicioConsultarHojaDeVidaPorIdUsuario = servicioConsultarHojaDeVidaPorIdUsuario;
    }

    @Override
    public HojaDeVidaPersonaDTO ejecutar(Long comando) {
       return this.servicioConsultarHojaDeVidaPorIdUsuario.ejecutar(comando);
    }
}