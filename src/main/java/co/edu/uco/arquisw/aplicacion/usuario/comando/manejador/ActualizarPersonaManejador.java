package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoActualizacionRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica.PersonaFabrica;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioActualizarPersona;
import org.springframework.stereotype.Component;

@Component
public class ActualizarPersonaManejador implements ManejadorComandoActualizacionRespuesta<PersonaComando, Long, ComandoRespuesta<Long>> {
    private final PersonaFabrica personaFabrica;
    private final ServicioActualizarPersona servicioActualizarPersona;

    public ActualizarPersonaManejador(PersonaFabrica personaFabrica, ServicioActualizarPersona servicioActualizarPersona) {
        this.personaFabrica = personaFabrica;
        this.servicioActualizarPersona = servicioActualizarPersona;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(PersonaComando comando, Long id) {
        return new ComandoRespuesta<>(this.servicioActualizarPersona.ejecutar(this.personaFabrica.construirActualizar(comando, id), id));
    }
}