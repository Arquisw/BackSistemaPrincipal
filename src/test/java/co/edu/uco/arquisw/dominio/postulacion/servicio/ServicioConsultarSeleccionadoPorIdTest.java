package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarSeleccionadoPorIdTest {
    @Test
    void validarConsultaSeleccionadoPorIdExitosa() {
        var seleccionadoDto = new SeleccionDTO();

        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioConsultarSeleccinadoPorId(postulacionRepositorioConsulta);

        Mockito.when(postulacionRepositorioConsulta.consultarSeleccionPorId(Mockito.anyLong())).thenReturn(seleccionadoDto);

        var seleccionConsultado = servicio.ejecutar(NumeroConstante.UNO);

        Mockito.verify(postulacionRepositorioConsulta, Mockito.times(2)).consultarSeleccionPorId(NumeroConstante.UNO);

        Assertions.assertEquals(seleccionadoDto, seleccionConsultado);

    }

    @Test
    void consultaSeleccionadoPorIdFallida() {
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioConsultarSeleccinadoPorId(postulacionRepositorioConsulta);

        Mockito.when(postulacionRepositorioConsulta.consultarSeleccionPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExistePostulacionConId(NumeroConstante.UNO),
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(NumeroConstante.UNO)
                ).getMessage());
    }
}