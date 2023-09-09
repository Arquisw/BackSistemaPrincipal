package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.DuplicidadExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarPersonaTest {
    @Test
    void noExistePersonaParaActualizar() {
        var persona = new PersonaTestDataBuilder().build();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioActualizarPersona(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.existeConCorreo(Mockito.any())).thenReturn(true);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1L, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(persona, 1L)).getMessage());
    }

    @Test
    void actualizarFallaYaExisteCorreo() {
        var persona = new PersonaTestDataBuilder().build();
        var personaDto = new PersonaDTO();
        personaDto.setCorreo("jjuandiego23@gmail.com");

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioActualizarPersona(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.any())).thenReturn(personaDto);
        Mockito.when(personaRepositorioConsulta.existeConCorreo(personaDto.getCorreo())).thenReturn(true);


        Assertions.assertEquals(Mensajes.EXISTE_USUARIO_CON_CORREO + personaDto.getCorreo(), Assertions.assertThrows(DuplicidadExcepcion.class, () -> servicio.ejecutar(persona, 1L)).getMessage());
    }

    @Test
    void personaActualizarExistosamente() {
        var persona = new PersonaTestDataBuilder().build();
        var personaDTO = new PersonaDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioActualizarPersona(personaRepositorioComando, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(personaDTO);

        servicio.ejecutar(persona, 1L);

        Mockito.verify(personaRepositorioComando, Mockito.times(1)).actualizar(persona, 1L);
    }
}
