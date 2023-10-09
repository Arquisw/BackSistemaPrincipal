package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.asociacion.testdatabuilder.AsociacionTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.excepciones.DuplicidadExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarAsociacionTest {
    @Test
    void actualizacionExitosa() {
        var asociacion = new AsociacionTestDataBuilder().build();
        AsociacionDTO asociacionDTO = new AsociacionDTO();

        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio = new ServicioActualizarAsociacion(asociacionRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(asociacionDTO);

        servicio.ejecutar(asociacion, NumeroConstante.UNO);

        Mockito.verify(asociacionRepositorioComando, Mockito.times(1)).actualizar(asociacion, NumeroConstante.UNO);
    }

    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacion() {

        var asociacion = new AsociacionTestDataBuilder().build();
        AsociacionDTO asociacionDTO = new AsociacionDTO();

        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio = new ServicioActualizarAsociacion(asociacionRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario((Mockito.anyLong()))).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteAsociacionConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(asociacion, NumeroConstante.UNO)).getMessage());
    }

    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacionPorNit() {

        var asociacion = new AsociacionTestDataBuilder().build();
        AsociacionDTO asociacionDTO = new AsociacionDTO();

        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio = new ServicioActualizarAsociacion(asociacionRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario((Mockito.anyLong()))).thenReturn(asociacionDTO);
        Mockito.when(asociacionRepositorioConsulta.consultarPorNIT((Mockito.anyString()))).thenReturn(asociacionDTO);

        Assertions.assertEquals(Mensajes.obtenerYaExisteAsociacionConNIT(asociacion.getNit()), Assertions.assertThrows(DuplicidadExcepcion.class, () -> servicio.ejecutar(asociacion, NumeroConstante.UNO)).getMessage());
    }
}