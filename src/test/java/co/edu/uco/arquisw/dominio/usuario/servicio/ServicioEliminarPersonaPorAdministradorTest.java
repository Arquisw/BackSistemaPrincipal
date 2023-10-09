package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarPersonaPorAdministradorTest {
    @Test
    void ValidarEliminacionNoExitosa() {
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicioNotificacionFactoria = Mockito.mock(ServicioNotificacionFactoria.class);

        var servicio = new ServicioEliminarPersonaPorAdministrador(personaRepositorioComando, personaRepositorioConsulta, servicioNotificacionFactoria);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteUsuarioConId(NumeroConstante.UNO),
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutar(NumeroConstante.UNO)).getMessage());
    }
}