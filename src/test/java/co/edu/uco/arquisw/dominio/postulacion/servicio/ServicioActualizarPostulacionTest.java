package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.testdatabuilder.PostulacionTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

 class ServicioActualizarPostulacionTest {



     @Captor
     ArgumentCaptor<Seleccion> selccionCaptor;

    @Test
    void actualizacionExitosa()
    {
        var postulacion = new PostulacionTestDataBuilder().build();
        var postulacionDto = new PostulacionDTO();

        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var servicio = new ServicioActualizarPostulacion(postulacionRepositorioConsulta,postulacionRepositorioComando);

        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class),Mockito.anyLong(),Mockito.anyLong())).thenReturn(1L);
        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(1L)).thenReturn(postulacionDto);

        var id =servicio.ejecutar(postulacion,1L);
        Assertions.assertEquals(0,id);

    }

     @Test
     void deberiaValidarLaExistenciaPreviaDeLaAsociacion()
     {
         var postulacion = new PostulacionTestDataBuilder().build();

         var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
         var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
         var servicio = new ServicioActualizarPostulacion(postulacionRepositorioConsulta,postulacionRepositorioComando);

         Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class),Mockito.anyLong(),Mockito.anyLong())).thenReturn(1L);
         Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(1L)).thenReturn(null);

         Assertions.assertEquals(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + 1, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(postulacion,1L)).getMessage());

     }
}
