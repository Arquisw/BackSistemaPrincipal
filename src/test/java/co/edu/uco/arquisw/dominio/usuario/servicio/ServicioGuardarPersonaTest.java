package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarPersonaTest
{
    @Test
    void guardarExitoso()
    {
        var persona= new PersonaTestDataBuilder().build();

        var repositorioPersonaComando = Mockito.mock(PersonaRepositorioComando.class);
        var repositorioPersonaConsulta= Mockito.mock(PersonaRepositorioConsulta.class);


        var servicio = new ServicioGuardarPersona(repositorioPersonaComando,repositorioPersonaConsulta);

        Mockito.when(repositorioPersonaComando.guardar(Mockito.any(Persona.class))).thenReturn(1l);

        var id = servicio.ejecutar(persona);

        Mockito.verify(repositorioPersonaComando,Mockito.times(1)).guardar(persona);

        Assertions.assertEquals(1L,id);
        Assertions.assertEquals("juan",persona.getNombre());

    }
}


