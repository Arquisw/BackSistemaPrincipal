package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.HojaDeVidaPersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.HojaDeVidaTestDataBuilder;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarHojaDeVidaTest {
    @Test
    void noExistePersonaParaActualizar()
    {
        var hojaDeVida = new HojaDeVidaTestDataBuilder().build();

        var  personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio= new ServicioActualizarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.any())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1L,Assertions.assertThrows(NullPointerException.class,()-> servicio.ejecutar(hojaDeVida,1L)).getMessage());
    }
    @Test
    void noExisteHojaDeVidaParaActualizar()
    {
        var hojaDeVida = new HojaDeVidaTestDataBuilder().build();
        var personaDTO= new PersonaDTO();

        var  personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio= new ServicioActualizarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(personaDTO);
        Mockito.when(personaRepositorioConsulta.consultarHojaDeVidaPorIdUsuario(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_HOJA_DE_VIDA_CON_EL_ID + 1L,Assertions.assertThrows(NullPointerException.class,()-> servicio.ejecutar(hojaDeVida,1L)).getMessage());
    }
    @Test
    void hojaDeVidaActualizarExistosamente()
    {
        var hojaDeVida = new HojaDeVidaTestDataBuilder().build();
        var personaDTO= new PersonaDTO();
        var hojaDeVidaDTO = new HojaDeVidaPersonaDTO();

        var  personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio= new ServicioActualizarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(personaDTO);
        Mockito.when(personaRepositorioConsulta.consultarHojaDeVidaPorIdUsuario(Mockito.anyLong())).thenReturn(hojaDeVidaDTO);
        servicio.ejecutar(hojaDeVida,1L);

        Mockito.verify(personaRepositorioComando,Mockito.times(1)).actualizarHojaDeVida(hojaDeVida,1L);
    }
}
