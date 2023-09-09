package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarContratoPorIdTest {
    @Test
    void validarConsultaPorIdExitosa() {
        var necesidad = new NecesidadDTO();

        var contratoRepositorioConsulta = Mockito.mock(ContratoRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarContratoPorId(contratoRepositorioConsulta, necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarPorNecesidadId(Mockito.anyLong())).thenReturn(necesidad);

        servicio.ejecutar(1L);

        Mockito.verify(contratoRepositorioConsulta, Mockito.times(1)).consultarPorId(1L);


    }

    @Test
    void consultaPorIdFallida() {
        var contratoRepositorioConsulta = Mockito.mock(ContratoRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarContratoPorId(contratoRepositorioConsulta, necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarPorNecesidadId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + 1L,
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(1L)
                ).getMessage());
    }
}