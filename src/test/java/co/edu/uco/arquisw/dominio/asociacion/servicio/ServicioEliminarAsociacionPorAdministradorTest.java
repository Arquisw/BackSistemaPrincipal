package co.edu.uco.arquisw.dominio.asociacion.servicio;


import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarAsociacionPorAdministradorTest {

    @Test
    void ValidarEliminacionFallidaNoExisteUsuario() {
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioNotificacionFactoria = Mockito.mock(ServicioNotificacionFactoria.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicio = new ServicioEliminarAsociacionPorAdministrador(asociacionRepositorioConsulta, asociacionRepositorioComando, personaRepositorioComando, servicioNotificacionFactoria, personaRepositorioConsulta);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1L,
                Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(1L)).getMessage());
    }
}
