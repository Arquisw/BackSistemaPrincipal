package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarAsociacionPorIdUsuarioTest {
    @Test
    void validarConsultaSeleccionadoPorProyectoExitosa() {
        var asociacionDto = new AsociacionDTO();

        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarAsociacionPorIDUsuario(asociacionRepositorioConsulta, personaRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(asociacionDto);

        servicio.ejecutar(1L);

        Mockito.verify(asociacionRepositorioConsulta, Mockito.times(2)).consultarPorIDUsuario(1L);
    }

    @Test
    void consultaSeleccionadoPorIdFallida() {
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarAsociacionPorIDUsuario(asociacionRepositorioConsulta, personaRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1L,
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(1L)
                ).getMessage());
    }
}
