package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarPostulacionPorUsuarioIdTest {
    @Test
    void validarConsultaPostulacionPorUsuarioPorIdExitosa()
    {
        var personaDTO = new PersonaDTO();
        var postulacionDTO = new PostulacionDTO();
        var personaID = 1L;

        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarPostulacionPorUsuarioId(postulacionRepositorioConsulta, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(personaID)).thenReturn(personaDTO);
        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorUsuarioId(personaID)).thenReturn(postulacionDTO);

        var resultado = servicio.ejecutar(personaID);

        Assertions.assertEquals(postulacionDTO, resultado);

        Mockito.verify(personaRepositorioConsulta).consultarPorId(personaID);
        Mockito.verify(postulacionRepositorioConsulta, Mockito.times(2)).consultarPostulacionPorUsuarioId(personaID);
    }
    @Test
    void consultaPorIdFallida()
    {
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarPostulacionPorUsuarioId(postulacionRepositorioConsulta,personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1L,
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(1L)
                ).getMessage());
    }
}
