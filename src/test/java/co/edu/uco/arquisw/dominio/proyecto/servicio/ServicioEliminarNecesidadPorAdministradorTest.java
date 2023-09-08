package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.mail.MessagingException;

class ServicioEliminarNecesidadPorAdministradorTest {
    @Test
    void ValidarEliminacionExitosa() throws MessagingException {
        var asociacion= new AsociacionDTO();

        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicioEnviarCorreoElectronico = Mockito.mock(ServicioEnviarCorreoElectronico.class);

        var servicio = new ServicioEliminarNecesidadPorAdministrador(asociacionRepositorioConsulta,necesidadRepositorioComando, necesidadRepositorioConsulta, personaRepositorioConsulta, servicioEnviarCorreoElectronico);

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
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicioEnviarCorreoElectronico = Mockito.mock(ServicioEnviarCorreoElectronico.class);

        var servicio = new ServicioEliminarNecesidadPorAdministrador(asociacionRepositorioConsulta,necesidadRepositorioComando, necesidadRepositorioConsulta, personaRepositorioConsulta, servicioEnviarCorreoElectronico);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1,
                Assertions.assertThrows(NullPointerException.class,() -> servicio.ejecutar(1L)).getMessage());
    }

}
