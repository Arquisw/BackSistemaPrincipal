package co.edu.uco.arquisw.dominio.asociacion.servicio;


import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarAsociacionPorAdministradorTest {
    @Test
    void ValidarEliminacionExitosa()
    {
        var persona= new PersonaDTO();

        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);

        var servicio = new ServicioEliminarAsociacionPorAdministrador(personaRepositorioConsulta,asociacionRepositorioComando, personaRepositorioComando);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);

        var id =servicio.ejecutar(1L);

        Mockito.verify(asociacionRepositorioComando,Mockito.times(1)).eliminar(1L);

        Assertions.assertEquals(1L,id);
    }
    @Test
    void ValidarEliminacionFallidaNoExisteUsuario()
    {
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);

        var servicio = new ServicioEliminarAsociacionPorAdministrador(personaRepositorioConsulta,asociacionRepositorioComando, personaRepositorioComando);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1,
                Assertions.assertThrows(NullPointerException.class,() -> servicio.ejecutar(1L)).getMessage());
    }
}
