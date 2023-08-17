package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.testDataBuilder.ContratoTestDataBuilder;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarContratoTest {
    @Test
    void noExisteAsociacionParaActualizarContrato()
    {
        var contrato = new ContratoTestDataBuilder().build();

        var  contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var  necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio= new ServicioActualizarContrato(contratoRepositorioComando, necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarPorNecesidadId(Mockito.any())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + 1L,Assertions.assertThrows(NullPointerException.class,()-> servicio.ejecutar(contrato,1L)).getMessage());
    }

    @Test
    void contratoActualizarExistosamente()
    {
        var contrato = new ContratoTestDataBuilder().build();
        var necesidad = new NecesidadDTO();

        var  contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var  necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio= new ServicioActualizarContrato(contratoRepositorioComando, necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarPorNecesidadId(Mockito.any())).thenReturn(necesidad);

        servicio.ejecutar(contrato,1L);

        Mockito.verify(contratoRepositorioComando,Mockito.times(1)).actualizar(contrato,1L);
    }
}
