package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarNecesidadPorAdministradorTest {
    @Test
    void ValidarEliminacionExitosa()
    {
        var asociacion= new AsociacionDTO();

        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var  necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);

        var servicio = new ServicioEliminarNecesidadPorAdministrador(asociacionRepositorioConsulta,necesidadRepositorioComando);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(asociacion);

        var id =servicio.ejecutar(1L);

        Mockito.verify(necesidadRepositorioComando,Mockito.times(1)).eliminar(1L);

        Assertions.assertEquals(1L,id);
    }
    @Test
    void ValidarEliminacionFallidaNoExisteUsuario()
    {
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var  necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);

        var servicio = new ServicioEliminarNecesidadPorAdministrador(asociacionRepositorioConsulta,necesidadRepositorioComando);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1,
                Assertions.assertThrows(NullPointerException.class,() -> servicio.ejecutar(1L)).getMessage());
    }

}
