package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.testdatabuilder.NesecidadTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarNecesidadTest {

    @Test
    void guardarNesecidadExitoso()
    {
        var nesecidad= new NesecidadTestDataBuilder().build();
        var asociacion = new AsociacionDTO();

        var necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);
        var asociacionRepositorioConsulta =Mockito.mock(AsociacionRepositorioConsulta.class);
        var asociacionRepositorioComando= Mockito.mock(AsociacionRepositorioComando.class);

        var servicio = new ServicioGuardarNecesidad(necesidadRepositorioComando,asociacionRepositorioConsulta);


        Mockito.when(asociacionRepositorioComando.guardar(Mockito.any(Asociacion.class),Mockito.anyLong())).thenReturn(1L);

        Mockito.when(necesidadRepositorioComando.guardar(Mockito.any(Necesidad.class),Mockito.anyLong())).thenReturn(1L);

        var id = servicio.ejecutar(nesecidad, 1L);

        Mockito.verify(necesidadRepositorioComando,Mockito.times(1)).guardar(nesecidad,1L);

        Assertions.assertEquals(1L,id);
        Assertions.assertEquals("http://www.direccion.org/ejemplo/item.html",nesecidad.getRutaArchivo());

    }
}
