package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarPersonaTest
{

    @Test
    void ValidarEliminacionExitosa()
    {
        var persona= new PersonaDTO();

       var  personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);

       var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

       var servicio = new ServicioEliminarPersona(personaRepositorioComando,personaRepositorioConsulta);

       Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);

       var id =servicio.ejecutar(1L);
       Mockito.verify(personaRepositorioComando,Mockito.times(1)).eliminar(1L);

       Assertions.assertEquals(1L,id);

    }

    @Test
    void ValidarEliminacionNoExitosa()
    {
        var persona= new PersonaTestDataBuilder().build();

        var  personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando,personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals("No existe un usuario con el id " + 1,
                Assertions.assertThrows(ValorInvalidoExcepcion.class,() -> servicio.ejecutar(1L)).getMessage());

    }

}
