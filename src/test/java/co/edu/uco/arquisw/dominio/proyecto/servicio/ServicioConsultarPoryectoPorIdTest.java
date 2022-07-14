package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioConsultarPoryectoPorIdTest {
    @Test
    void validarConsultaProyectoPorIdExitosa()
    {
        var proyectoDto = new ProyectoDTO();

        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarProyectoPorId(necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(proyectoDto);

        var proyectoConsultado = servicio.ejecutar(1L);

        Mockito.verify(necesidadRepositorioConsulta, Mockito.times(2)).consultarProyectoPorId(1L);

        Assertions.assertEquals(proyectoDto, proyectoConsultado);
    }
    @Test
    void consultaPorIdFallida()
    {
        var necesidadRepositorioConsulta =Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarProyectoPorId(necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + 1L,
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(1L)
                ).getMessage());
    }
}
