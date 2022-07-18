package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.testDataBuilder.ContratoTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarContratoTest {
    @Test
    void noExisteAsociacionParaGuardarContrato()
    {
        var contrato = new ContratoTestDataBuilder().build();

        var  contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio= new ServicioGuardarContrato(contratoRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.any())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1L,Assertions.assertThrows(NullPointerException.class,()-> servicio.ejecutar(contrato,1L)).getMessage());
    }
    @Test
    void contratoActualizarExistosamente()
    {
        var contrato = new ContratoTestDataBuilder().build();
        var asociacion = new AsociacionDTO();

        var  contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio= new ServicioGuardarContrato(contratoRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.any())).thenReturn(asociacion);

        servicio.ejecutar(contrato,1L);

        Mockito.verify(contratoRepositorioComando,Mockito.times(1)).guardar(contrato,1L);
    }
}
