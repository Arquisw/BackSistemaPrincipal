package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.asociacion.testdatabuilder.AsociacionTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarAsociacionTest {

    @Test
    void actualizacionExitosa()
    {
        var asociacion = new AsociacionTestDataBuilder().build();
        AsociacionDTO asociacionDTO = new AsociacionDTO();

        var  asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio = new ServicioActualizarAsociacion(asociacionRepositorioComando,asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(asociacionDTO);

        servicio.ejecutar(asociacion,1L);

        Mockito.verify(asociacionRepositorioComando,Mockito.times(1)).actualizar(asociacion,1L);
    }
}
