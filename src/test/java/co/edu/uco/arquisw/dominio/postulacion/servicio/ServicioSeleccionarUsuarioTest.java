package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.testdatabuilder.PostulacionTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioSeleccionarUsuarioTest {
    @Test
    void actualizacionExitosa()
    {
        var postulacion = new PostulacionTestDataBuilder().build();
        var postulacionDto = new PostulacionDTO();

        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);

        var servicio = new ServicioSeleccionarUsuario(postulacionRepositorioConsulta,postulacionRepositorioComando, personaRepositorioComando);

        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class),Mockito.anyLong(),Mockito.anyLong())).thenReturn(1L);
        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(1L)).thenReturn(postulacionDto);

        var id =servicio.ejecutar(1L);
        Assertions.assertEquals(0,id);

    }

     @Test
     void deberiaValidarLaExistenciaPreviaDeLaAsociacion()
     {
         var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
         var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
         var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);

         var servicio = new ServicioSeleccionarUsuario(postulacionRepositorioConsulta,postulacionRepositorioComando, personaRepositorioComando);

         Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class),Mockito.anyLong(),Mockito.anyLong())).thenReturn(1L);
         Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(1L)).thenReturn(null);

         Assertions.assertEquals(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + 1, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(1L)).getMessage());

     }
}
