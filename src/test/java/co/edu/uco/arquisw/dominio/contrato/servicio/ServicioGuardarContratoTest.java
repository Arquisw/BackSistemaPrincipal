package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.FaseRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.testDataBuilder.ContratoTestDataBuilder;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarContratoTest {
    @Test
    void noExisteAsociacionParaGuardarContrato()
    {
        var contrato = new ContratoTestDataBuilder().build();
        var token = "token";

        var contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);
        var faseRepositorioComando = Mockito.mock(FaseRepositorioComando.class);

        var servicio= new ServicioGuardarContrato(contratoRepositorioComando, necesidadRepositorioConsulta, necesidadRepositorioComando, faseRepositorioComando);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.any())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + 1L,Assertions.assertThrows(NullPointerException.class,()-> servicio.ejecutar(contrato,1L, token)).getMessage());
    }
    @Test
    void contratoGuardarExistosamente()
    {
        var contrato = new ContratoTestDataBuilder().build();
        var necesidad = new NecesidadDTO();
        var token = "token";
        necesidad.setProyecto(new ProyectoDTO());
        necesidad.getProyecto().setId(1L);

        var  contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var  necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var  necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);
        var faseRepositorioComando = Mockito.mock(FaseRepositorioComando.class);

        var servicio= new ServicioGuardarContrato(contratoRepositorioComando, necesidadRepositorioConsulta, necesidadRepositorioComando, faseRepositorioComando);

        Mockito.when(necesidadRepositorioConsulta.consultarPorId(1L)).thenReturn(necesidad);

        servicio.ejecutar(contrato,1L, token);

        Mockito.verify(contratoRepositorioComando,Mockito.times(1)).guardar(contrato,1L);
    }
}
