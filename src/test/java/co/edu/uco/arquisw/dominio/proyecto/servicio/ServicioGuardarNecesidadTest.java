package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.testdatabuilder.NesecidadTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarNecesidadTest
{
    @Test
    void guardarNesecidadExitoso()
    {
        var nesecidad= new NesecidadTestDataBuilder().build();
        var asociacionDto = new AsociacionDTO();

        var necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);
        var asociacionRepositorioConsulta =Mockito.mock(AsociacionRepositorioConsulta.class);
        var servicio = new ServicioGuardarNecesidad(necesidadRepositorioComando,asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(asociacionDto);
        Mockito.when(necesidadRepositorioComando.guardar(Mockito.any(Necesidad.class),Mockito.anyLong())).thenReturn(1L);

        var id = servicio.ejecutar(nesecidad, 1L);

        Mockito.verify(necesidadRepositorioComando,Mockito.times(1)).guardar(nesecidad,1L);

        Assertions.assertEquals(1L,id);
    }
    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacion() {

        var nesecidad= new NesecidadTestDataBuilder().build();

        var  necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var servicio = new ServicioActualizarNecesidad(asociacionRepositorioConsulta,necesidadRepositorioComando);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario((Mockito.anyLong()))).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(nesecidad,1L)).getMessage());
    }
}
