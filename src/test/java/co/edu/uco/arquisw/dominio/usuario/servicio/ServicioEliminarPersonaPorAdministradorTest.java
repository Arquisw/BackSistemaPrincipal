package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.mail.MessagingException;

class ServicioEliminarPersonaPorAdministradorTest {
    @Test
    void ValidarEliminacionExitosa() throws MessagingException {
        var persona = new PersonaDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicioEnviarCorreoElectronico = Mockito.mock(ServicioEnviarCorreoElectronico.class);

        var servicio = new ServicioEliminarPersonaPorAdministrador(personaRepositorioComando, personaRepositorioConsulta, servicioEnviarCorreoElectronico);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);

        var id = servicio.ejecutar(1L);
        Mockito.verify(personaRepositorioComando, Mockito.times(1)).eliminar(1L);

        Assertions.assertEquals(1L, id);
    }

    @Test
    void ValidarEliminacionNoExitosa() {
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicioEnviarCorreoElectronico = Mockito.mock(ServicioEnviarCorreoElectronico.class);

        var servicio = new ServicioEliminarPersonaPorAdministrador(personaRepositorioComando, personaRepositorioConsulta, servicioEnviarCorreoElectronico);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1,
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutar(1L)).getMessage());
    }
}
