package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.asociacion.servicio.ServicioEliminarAsociacion;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.mail.MessagingException;

class ServicioEliminarNecesidadTest {
    @Test
    void ValidarEliminacionExitosa() throws MessagingException {
        var persona = new PersonaDTO();
        var asociacion = new AsociacionDTO();

        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioActualizarToken = Mockito.mock(ServicioActualizarToken.class);
        var servicioNotificacionFactoria = Mockito.mock(ServicioNotificacionFactoria.class);

        var servicio = new ServicioEliminarAsociacion(personaRepositorioConsulta, asociacionRepositorioComando, asociacionRepositorioConsulta, necesidadRepositorioConsulta, personaRepositorioComando, servicioActualizarToken, servicioNotificacionFactoria);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(asociacion);

        var id = servicio.ejecutar(1L);

        Mockito.verify(asociacionRepositorioComando, Mockito.times(1)).eliminar(1L);

        Assertions.assertEquals(1L, id);
    }

    @Test
    void ValidarEliminacionFallidaNoExisteUsuario() {

        var asociacion = new AsociacionDTO();

        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioActualizarToken = Mockito.mock(ServicioActualizarToken.class);
        var servicioNotificacionFactoria = Mockito.mock(ServicioNotificacionFactoria.class);
        var servicio = new ServicioEliminarAsociacion(personaRepositorioConsulta, asociacionRepositorioComando, asociacionRepositorioConsulta, necesidadRepositorioConsulta, personaRepositorioComando, servicioActualizarToken, servicioNotificacionFactoria);
        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(asociacion);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1,
                Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(1L)).getMessage());
    }

    @Test
    void ValidarEliminacionFallidaExisteUnaNecesidad() {
        var asociacion = new AsociacionDTO();
        asociacion.setId(1L);
        var persona = new PersonaDTO();
        var necesidad = new NecesidadDTO();

        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioActualizarToken = Mockito.mock(ServicioActualizarToken.class);
        var servicioNotificacionFactoria = Mockito.mock(ServicioNotificacionFactoria.class);
        var servicio = new ServicioEliminarAsociacion(personaRepositorioConsulta, asociacionRepositorioComando, asociacionRepositorioConsulta, necesidadRepositorioConsulta, personaRepositorioComando, servicioActualizarToken, servicioNotificacionFactoria);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(asociacion);
        Mockito.when(necesidadRepositorioConsulta.consultarPorAsociacionId(Mockito.anyLong())).thenReturn(necesidad);

        Assertions.assertEquals(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_REGISTRADA,
                Assertions.assertThrows(AutorizacionExcepcion.class, () -> servicio.ejecutar(1L)).getMessage());
    }
}