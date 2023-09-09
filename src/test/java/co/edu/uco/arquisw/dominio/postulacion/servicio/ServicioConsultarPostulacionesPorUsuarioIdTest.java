package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarPostulacionesPorUsuarioIdTest {
    @Test
    void consultaPorIdFallida() {
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio = new ServicioConsultarPostulacionesPorUsuarioId(postulacionRepositorioConsulta, personaRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1L, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(1L)).getMessage());
    }
}