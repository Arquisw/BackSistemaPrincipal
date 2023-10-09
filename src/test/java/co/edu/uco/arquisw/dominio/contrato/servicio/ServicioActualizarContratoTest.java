package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.contrato.testDataBuilder.ContratoTestDataBuilder;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarContratoTest {
    @Test
    void noExisteAsociacionParaActualizarContrato() {
        var contrato = new ContratoTestDataBuilder().build();

        var contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicioNotificacionFactoria = Mockito.mock(ServicioNotificacionFactoria.class);

        var servicio = new ServicioActualizarContrato(contratoRepositorioComando, necesidadRepositorioConsulta, asociacionRepositorioConsulta, personaRepositorioConsulta, servicioNotificacionFactoria);

        Mockito.when(necesidadRepositorioConsulta.consultarPorNecesidadId(Mockito.any())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteNecesidadConId(NumeroConstante.UNO), Assertions.assertThrows(NullPointerException.class, () -> servicio.ejecutar(contrato, NumeroConstante.UNO)).getMessage());
    }
}