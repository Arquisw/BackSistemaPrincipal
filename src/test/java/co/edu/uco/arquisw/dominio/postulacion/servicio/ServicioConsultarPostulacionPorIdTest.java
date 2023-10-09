package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarPostulacionPorIdTest {
    @Test
    void validarConsultaPostulacionPorIdExitosa() {
        var postulacionDto = new PostulacionDTO();

        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioConsultarPostulacionPorId(postulacionRepositorioConsulta);

        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(Mockito.anyLong())).thenReturn(postulacionDto);

        var postulacionConsultado = servicio.ejecutar(NumeroConstante.UNO);

        Mockito.verify(postulacionRepositorioConsulta, Mockito.times(2)).consultarPostulacionPorId(NumeroConstante.UNO);

        Assertions.assertEquals(postulacionDto, postulacionConsultado);

    }

    @Test
    void consultaPorIdFallida() {
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioConsultarPostulacionPorId(postulacionRepositorioConsulta);

        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExistePostulacionConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(NumeroConstante.UNO)).getMessage());
    }
}