package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.servicio.ServicioConsultarSeleccionadoPorProyecto;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarAsociacionPorIdTest {
    @Test
    void validarConsultaSeleccionadoPorProyectoExitosa()
    {
        var asociacionDto = new AsociacionDTO();

        var asociacionRepositorioConsulta =Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio = new ServicioConsultarAsociacionPorID(asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(asociacionDto);

        servicio.ejecutar(1L);

        Mockito.verify(asociacionRepositorioConsulta, Mockito.times(2)).consultarPorID(1L);
    }
    @Test
    void consultaSeleccionadoPorIdFallida()
    {
        var asociacionRepositorioConsulta =Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio = new ServicioConsultarAsociacionPorID(asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1L,
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(1L)
                ).getMessage());
    }
}
