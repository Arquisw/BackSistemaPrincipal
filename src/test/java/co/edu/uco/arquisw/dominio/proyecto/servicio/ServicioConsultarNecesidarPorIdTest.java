package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarNecesidarPorIdTest {
    @Test
    void consultaPorIdFallida() {
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarNecesidadPorId(necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarPorAsociacionId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteNecesidadConId(NumeroConstante.UNO),
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(NumeroConstante.UNO)
                ).getMessage());
    }
}