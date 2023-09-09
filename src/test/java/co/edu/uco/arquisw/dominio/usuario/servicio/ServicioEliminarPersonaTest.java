package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ServicioEliminarPersonaTest {
    @Test
    void ValidarEliminacionFallidaNoExisteUsuario() {
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var servicioEnviarCorreoElectronico = Mockito.mock(ServicioEnviarCorreoElectronico.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta, asociacionRepositorioConsulta, postulacionRepositorioConsulta, servicioEnviarCorreoElectronico);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1,
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutar(1L)).getMessage());
    }

    @Test
    void ValidarEliminacionFallidaExisteAsociacion() {
        var persona = new PersonaDTO();
        var asociacion = new AsociacionDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var servicioEnviarCorreoElectronico = Mockito.mock(ServicioEnviarCorreoElectronico.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta, asociacionRepositorioConsulta, postulacionRepositorioConsulta, servicioEnviarCorreoElectronico);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario(Mockito.anyLong())).thenReturn(asociacion);

        Assertions.assertEquals(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_ASOCIACION_A_CARGO,
                Assertions.assertThrows(AutorizacionExcepcion.class, () -> servicio.ejecutar(1L)).getMessage());
    }

    @Test
    void ValidarEliminacionFallidaEstaSeleccionado() {
        var persona = new PersonaDTO();
        var seleccionado = new SeleccionDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var servicioEnviarCorreoElectronico = Mockito.mock(ServicioEnviarCorreoElectronico.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta, asociacionRepositorioConsulta, postulacionRepositorioConsulta, servicioEnviarCorreoElectronico);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(postulacionRepositorioConsulta.consultarSeleccionesPorUsuarioId(Mockito.anyLong())).thenReturn(List.of(seleccionado));

        Assertions.assertEquals(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_SELECCIONADO_EN_UN_PROYECTO,
                Assertions.assertThrows(AutorizacionExcepcion.class, () -> servicio.ejecutar(1L)).getMessage());
    }
}
