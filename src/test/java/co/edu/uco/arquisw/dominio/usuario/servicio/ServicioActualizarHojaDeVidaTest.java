package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.HojaDeVidaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarHojaDeVidaTest {
    @Test
    void noExistePersonaParaActualizar() {
        var hojaDeVida = new HojaDeVidaTestDataBuilder().build();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioActualizarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.any())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteUsuarioConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(hojaDeVida, NumeroConstante.UNO)).getMessage());
    }

    @Test
    void noExisteHojaDeVidaParaActualizar() {
        var hojaDeVida = new HojaDeVidaTestDataBuilder().build();
        var personaDTO = new PersonaDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioActualizarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(personaDTO);
        Mockito.when(personaRepositorioConsulta.consultarHojaDeVidaPorIdUsuario(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteHojaDeVidaParaUsuarioConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(hojaDeVida, NumeroConstante.UNO)).getMessage());
    }

    @Test
    void hojaDeVidaActualizarExistosamente() {
        var hojaDeVida = new HojaDeVidaTestDataBuilder().build();
        var personaDTO = new PersonaDTO();
        var hojaDeVidaDTO = new HojaDeVidaPersonaDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioActualizarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(personaDTO);
        Mockito.when(personaRepositorioConsulta.consultarHojaDeVidaPorIdUsuario(Mockito.anyLong())).thenReturn(hojaDeVidaDTO);
        servicio.ejecutar(hojaDeVida, NumeroConstante.UNO);

        Mockito.verify(personaRepositorioComando, Mockito.times(1)).actualizarHojaDeVida(hojaDeVida, NumeroConstante.UNO);
    }
}