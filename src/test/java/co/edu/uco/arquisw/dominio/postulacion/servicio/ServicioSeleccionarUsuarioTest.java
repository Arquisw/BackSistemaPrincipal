package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ServicioSeleccionarUsuarioTest {

    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacion() {
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioActualizarToken = Mockito.mock(ServicioActualizarToken.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicioNotificacionFactoria = Mockito.mock(ServicioNotificacionFactoria.class);

        var servicio = new ServicioSeleccionarUsuario(postulacionRepositorioConsulta, postulacionRepositorioComando, personaRepositorioComando, servicioActualizarToken, personaRepositorioConsulta, servicioNotificacionFactoria);
        var roles = List.of("ROLE_INGENIERIA");
        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class), Mockito.anyLong(), Mockito.anyLong())).thenReturn(NumeroConstante.UNO);
        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(NumeroConstante.UNO)).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExistePostulacionConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(roles, NumeroConstante.UNO)).getMessage());

    }
}