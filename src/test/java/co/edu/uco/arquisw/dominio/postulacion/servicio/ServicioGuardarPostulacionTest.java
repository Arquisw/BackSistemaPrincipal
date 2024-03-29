package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.testdatabuilder.PostulacionTestDataBuilder;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarPostulacionTest {
    @Test
    void deberiaValidarLaExistenciaPreviaDeLaProyecto() {
        var postulado = new PostulacionTestDataBuilder().build();
        var persona = new PersonaDTO();


        var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioActualizarToken = Mockito.mock(ServicioActualizarToken.class);
        var servicio = new ServicioGuardarPostulacion(postulacionRepositorioComando, personaRepositorioConsulta, necesidadRepositorioConsulta, personaRepositorioComando, servicioActualizarToken);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(null);
        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class), Mockito.anyLong(), Mockito.anyLong())).thenReturn(NumeroConstante.UNO);

        Assertions.assertEquals(Mensajes.obtenerNoExisteProyectoConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(postulado, NumeroConstante.UNO, NumeroConstante.UNO)).getMessage());
    }

    @Test
    void deberiaValidarLaExistenciaPreviaDeLaPersona() {
        var postulado = new PostulacionTestDataBuilder().build();
        var proyecto = new ProyectoDTO();

        var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioActualizarToken = Mockito.mock(ServicioActualizarToken.class);
        var servicio = new ServicioGuardarPostulacion(postulacionRepositorioComando, personaRepositorioConsulta, necesidadRepositorioConsulta, personaRepositorioComando, servicioActualizarToken);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(proyecto);
        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);
        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class), Mockito.anyLong(), Mockito.anyLong())).thenReturn(NumeroConstante.UNO);

        Assertions.assertEquals(Mensajes.obtenerNoExisteUsuarioConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(postulado, NumeroConstante.UNO, NumeroConstante.UNO)).getMessage());
    }
}