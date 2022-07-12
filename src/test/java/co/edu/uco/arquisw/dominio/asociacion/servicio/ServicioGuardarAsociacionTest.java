package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.asociacion.testdatabuilder.AsociacionTestDataBuilder;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarAsociacionTest
{
    @Test
    void guardarExitoso()
    {
        var asociacion= new AsociacionTestDataBuilder().build();
        var personaDTO= new PersonaDTO();

        var repositorioAsociacionComando = Mockito.mock(AsociacionRepositorioComando.class);
        var repositorioAsociacionConsulta= Mockito.mock(AsociacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicio = new ServicioGuardarAsociacion(repositorioAsociacionComando,repositorioAsociacionConsulta,personaRepositorioConsulta);

        Mockito.when(repositorioAsociacionComando.guardar(Mockito.any(Asociacion.class),Mockito.anyLong())).thenReturn(1L);
        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(personaDTO);

        var id = servicio.ejecutar(asociacion,1L);

        Mockito.verify(repositorioAsociacionComando,Mockito.times(1)).guardar(asociacion,1L);

        Assertions.assertEquals(1L,id);
        Assertions.assertEquals("Uco",asociacion.getNombre());

    }
}
