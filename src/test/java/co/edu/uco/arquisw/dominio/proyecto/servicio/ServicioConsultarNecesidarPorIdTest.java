package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioConsultarNecesidarPorIdTest {
    @Test
    void validarConsultaNecesidadPorIdExitosa()
    {
        var necesidadDTO = new NecesidadDTO();

        var necesidadRepositorioConsulta =Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarNecesidadPorId(necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(necesidadDTO);

        var necesidadConsultada = servicio.ejecutar(1L);

        Mockito.verify(necesidadRepositorioConsulta, Mockito.times(2)).consultarPorId(1L);

        Assertions.assertEquals(necesidadDTO, necesidadConsultada);
    }
    @Test
    void consultaPorIdFallida()
    {
        var necesidadRepositorioConsulta =Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarNecesidadPorId(necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + 1L,
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(1L)
                ).getMessage());
    }
}
