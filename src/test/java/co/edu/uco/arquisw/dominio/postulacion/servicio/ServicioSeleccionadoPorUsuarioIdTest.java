package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ServicioSeleccionadoPorUsuarioIdTest {
    @Test
    void validarConsultaSeleccionadoPorProyectoExitosa() {
        var personaDto = new PersonaDTO();
        var seleccionDTO = new SeleccionDTO();
        var personaID = NumeroConstante.UNO;

        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarSeleccionesPorUsuarioId(postulacionRepositorioConsulta, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(personaID)).thenReturn(personaDto);
        Mockito.when(postulacionRepositorioConsulta.consultarSeleccionesPorUsuarioId(personaID)).thenReturn(List.of(seleccionDTO));

        servicio.ejecutar(personaID);

        Mockito.verify(personaRepositorioConsulta).consultarPorId(personaID);
        Mockito.verify(postulacionRepositorioConsulta, Mockito.times(2)).consultarSeleccionesPorUsuarioId(personaID);
    }

    @Test
    void consultaSeleccionadoPorIdFallida() {
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarSeleccionesPorUsuarioId(postulacionRepositorioConsulta, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteUsuarioConId(NumeroConstante.UNO),
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(NumeroConstante.UNO)
                ).getMessage());
    }
}