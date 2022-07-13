package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.testdatabuilder.PostulacionTestDataBuilder;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarPostulacionTest {
    @Test
    void guardarExitoso()
    {
        var postulado= new PostulacionTestDataBuilder().build();
        var proyecto = new ProyectoDTO();
        var persona = new PersonaDTO();

        var  postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var  necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioGuardarPostulacion(postulacionRepositorioComando,personaRepositorioConsulta,necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(proyecto);
        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class),Mockito.anyLong(),Mockito.anyLong())).thenReturn(1l);

        var id = servicio.ejecutar(postulado,1L,1L);

        Mockito.verify(postulacionRepositorioComando,Mockito.times(1)).guardar(postulado,1L,1L);

    }
    @Test
    void deberiaValidarLaExistenciaPreviaDeLaProyecto()
    {
        var postulado= new PostulacionTestDataBuilder().build();
        var persona = new PersonaDTO();


        var  postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var  necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioGuardarPostulacion(postulacionRepositorioComando,personaRepositorioConsulta,necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(null);
        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class),Mockito.anyLong(),Mockito.anyLong())).thenReturn(1l);

        Assertions.assertEquals(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + 1, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(postulado,1L,1L)).getMessage());
    }

    @Test
    void deberiaValidarLaExistenciaPreviaDeLaPersona()
    {
        var postulado= new PostulacionTestDataBuilder().build();
        var proyecto = new ProyectoDTO();


        var  postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var  necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioGuardarPostulacion(postulacionRepositorioComando,personaRepositorioConsulta,necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(proyecto);
        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);
        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class),Mockito.anyLong(),Mockito.anyLong())).thenReturn(1l);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(postulado,1L,1L)).getMessage());
    }
}
