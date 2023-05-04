package co.edu.uco.arquisw.aplicacion.usuario.comando.manejador;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica.PersonaFabrica;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioGuardarPersona;
import org.springframework.stereotype.Component;

@Component
public class GuardarPersonaManejador implements ManejadorComandoRespuesta<PersonaComando, ComandoRespuesta<Long>> {
    private final PersonaFabrica personaFabrica;
    private final ServicioGuardarPersona servicioGuardarPersona;

    public GuardarPersonaManejador(PersonaFabrica personaFabrica, ServicioGuardarPersona servicioGuardarPersona) {
        this.personaFabrica = personaFabrica;
        this.servicioGuardarPersona = servicioGuardarPersona;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(PersonaComando comando) {
        Persona persona = this.personaFabrica.construir(comando);
        return new ComandoRespuesta<>(this.servicioGuardarPersona.ejecutar(persona));
    }
}