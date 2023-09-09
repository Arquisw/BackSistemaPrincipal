package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.testdatabuilder.PostulacionTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ServicioSeleccionarUsuarioTest {
    @Test
    void seleccionarUsuarioExitosamente() {
        var postulacion = new PostulacionTestDataBuilder().build();
        var postulacionDto = new PostulacionDTO();
        var postulacionID = 1L;
        var personaID = 1L;

        postulacionDto.setRoles(postulacion.getRoles());
        postulacionDto.setUsuarioID(personaID);

        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioActualizarToken = Mockito.mock(ServicioActualizarToken.class);
        var servicio = new ServicioSeleccionarUsuario(postulacionRepositorioConsulta, postulacionRepositorioComando, personaRepositorioComando, servicioActualizarToken);
        var roles = List.of("ROLE_INGENIERIA");
        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(postulacionID)).thenReturn(postulacionDto);
        Mockito.doNothing().when(personaRepositorioComando).eliminarRol(Mockito.any(Rol.class), Mockito.anyLong());
        Mockito.doNothing().when(personaRepositorioComando).crearRol(Mockito.any(Rol.class), Mockito.anyLong());
        Mockito.doNothing().when(personaRepositorioComando).crearRol(Mockito.any(Rol.class), Mockito.anyLong());

        var id = servicio.ejecutar(roles, 1L);

        Assertions.assertEquals(0L, id);
    }

    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacion() {
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var postulacionRepositorioComando = Mockito.mock(PostulacionRepositorioComando.class);
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var servicioActualizarToken = Mockito.mock(ServicioActualizarToken.class);
        var servicio = new ServicioSeleccionarUsuario(postulacionRepositorioConsulta, postulacionRepositorioComando, personaRepositorioComando, servicioActualizarToken);
        var roles = List.of("ROLE_INGENIERIA");
        Mockito.when(postulacionRepositorioComando.guardar(Mockito.any(Postulacion.class), Mockito.anyLong(), Mockito.anyLong())).thenReturn(1L);
        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorId(1L)).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + 1, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(roles, 1L)).getMessage());

    }
}