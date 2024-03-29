package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.HojaDeVidaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarHojaDeVidaTest {
    @Test
    void guardarExitoso() {
        var hojadeVida = new HojaDeVidaTestDataBuilder().build();
        var personaDto = new PersonaDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicio = new ServicioGuardarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(personaDto);

        servicio.ejecutar(hojadeVida, NumeroConstante.UNO);

        Mockito.verify(personaRepositorioComando, Mockito.times(1)).guardarHojaDeVida(hojadeVida, NumeroConstante.UNO);
    }

    @Test
    void validarSiNoExisteUsuario() {

        var hojadeVida = new HojaDeVidaTestDataBuilder().build();

        var repositorioPersonaComando = Mockito.mock(PersonaRepositorioComando.class);
        var repositorioPersonaConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicio = new ServicioGuardarHojaDeVida(repositorioPersonaComando, repositorioPersonaConsulta);

        Mockito.when(repositorioPersonaConsulta.consultarPorCorreo((Mockito.anyString()))).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteUsuarioConId(NumeroConstante.UNO), Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutar(hojadeVida, NumeroConstante.UNO)).getMessage());
    }
}