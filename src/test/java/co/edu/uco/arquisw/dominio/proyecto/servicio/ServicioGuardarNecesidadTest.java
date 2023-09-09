package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.testdatabuilder.NesecidadTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarNecesidadTest {
    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacion() {

        var nesecidad = new NesecidadTestDataBuilder().build();

        var necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var servicio = new ServicioActualizarNecesidad(asociacionRepositorioConsulta, necesidadRepositorioComando);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario((Mockito.anyLong()))).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1, Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(nesecidad, 1L)).getMessage());
    }
}