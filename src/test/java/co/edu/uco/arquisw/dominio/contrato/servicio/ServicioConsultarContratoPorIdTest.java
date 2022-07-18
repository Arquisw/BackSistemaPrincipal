package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarContratoPorIdTest {
    @Test
    void validarConsultaPorIdExitosa()
    {
        var asociacion = new AsociacionDTO();

        var  contratoRepositorioConsulta = Mockito.mock(ContratoRepositorioConsulta.class);
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio= new ServicioConsultarContratoPorId(contratoRepositorioConsulta, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(asociacion);

         servicio.ejecutar(1L);

        Mockito.verify(contratoRepositorioConsulta, Mockito.times(1)).consultarPorId(1L);


    }
    @Test
    void consultaPorIdFallida()
    {
        var  contratoRepositorioConsulta = Mockito.mock(ContratoRepositorioConsulta.class);
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio= new ServicioConsultarContratoPorId(contratoRepositorioConsulta, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1L,
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(1L)
                ).getMessage());
    }
}
