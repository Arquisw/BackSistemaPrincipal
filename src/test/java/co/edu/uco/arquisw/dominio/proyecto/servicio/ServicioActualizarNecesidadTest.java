package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.testdatabuilder.NesecidadTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarNecesidadTest {
    @Test
    void deberiaValidarLaExistenciaPreviaDeLaAsociacion() {

        var nesecidad = new NesecidadTestDataBuilder().build();

        var necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var servicio = new ServicioActualizarNecesidad(asociacionRepositorioConsulta, necesidadRepositorioComando);

        Mockito.when(asociacionRepositorioConsulta.consultarPorIDUsuario((Mockito.anyLong()))).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteAsociacionConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(nesecidad, NumeroConstante.UNO)).getMessage());
    }
}