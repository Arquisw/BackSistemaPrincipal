package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarHojaDeVidaPorIdUsuarioTest {
    @Test
    void validarConsultaPorIdExitosa()
    {
        var persona = new PersonaDTO();

        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarHojaDeVidaPorIdUsuario(personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);

        var personaConsultada = servicio.ejecutar(1L);

        Mockito.verify(personaRepositorioConsulta, Mockito.times(1)).consultarHojaDeVidaPorIdUsuario(1L);

        Assertions.assertEquals(personaConsultada, personaConsultada);
    }
    @Test
    void consultaPorIdHojaDeVidaFallida()
    {
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarHojaDeVidaPorIdUsuario(personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1L,
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutar(1L)
                ).getMessage());
    }
}
