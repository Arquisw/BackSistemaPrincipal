package co.edu.uco.arquisw.dominio.asociacion.servicio;


import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarAsociacionPorAdministradorTest {
    @Test
    void ValidarEliminacionExitosa()
    {
        var asociacion= new AsociacionDTO();

        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);

        var servicio = new ServicioEliminarAsociacionPorAdministrador(asociacionRepositorioConsulta, asociacionRepositorioComando, personaRepositorioComando);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(asociacion);

        var id = servicio.ejecutar(1L);

        Mockito.verify(asociacionRepositorioComando,Mockito.times(1)).eliminar(1L);

        Assertions.assertEquals(1L,id);
    }

    @Test
    void ValidarEliminacionFallidaNoExisteUsuario()
    {
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var personaRepositorioComando=Mockito.mock(PersonaRepositorioComando.class);

        var servicio = new ServicioEliminarAsociacionPorAdministrador(asociacionRepositorioConsulta, asociacionRepositorioComando, personaRepositorioComando);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1,
                Assertions.assertThrows(NullPointerException.class,() -> servicio.ejecutar(1L)).getMessage());
    }
}
