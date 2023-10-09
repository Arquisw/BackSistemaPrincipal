package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarHojaDeVidaPorIdUsuarioTest {
    @Test
    void validarConsultaPorIdExitosa() {
        var persona = new PersonaDTO();

        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarHojaDeVidaPorIdUsuario(personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);

        servicio.ejecutar(NumeroConstante.UNO);

        Mockito.verify(personaRepositorioConsulta, Mockito.times(1)).consultarHojaDeVidaPorIdUsuario(NumeroConstante.UNO);
    }

    @Test
    void consultaPorIdHojaDeVidaFallida() {
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarHojaDeVidaPorIdUsuario(personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteUsuarioConId(NumeroConstante.UNO),
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutar(NumeroConstante.UNO)
                ).getMessage());
    }
}