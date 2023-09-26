package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.asociacion.testdatabuilder.AsociacionTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.excepciones.DuplicidadExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarAsociacionTest {
    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacion() {

        var asociacion = new AsociacionTestDataBuilder().build();
        AsociacionDTO asociacionDTO = new AsociacionDTO();

        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio = new ServicioActualizarAsociacion(asociacionRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario((Mockito.anyLong()))).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(asociacion, 1L)).getMessage());
    }

    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacionPorNit() {

        var asociacion = new AsociacionTestDataBuilder().build();
        AsociacionDTO asociacionDTO = new AsociacionDTO();

        var asociacionRepositorioComando = Mockito.mock(AsociacionRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio = new ServicioActualizarAsociacion(asociacionRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario((Mockito.anyLong()))).thenReturn(asociacionDTO);
        Mockito.when(asociacionRepositorioConsulta.consultarPorNIT((Mockito.anyString()))).thenReturn(asociacionDTO);

        Assertions.assertEquals(Mensajes.EXISTE_ASOCIACION_CON_NIT + asociacion.getNit(), Assertions.assertThrows(DuplicidadExcepcion.class, () -> servicio.ejecutar(asociacion, 1L)).getMessage());
    }
}
