package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioEliminarPersonaPorAdministrador;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarContratoTest {
    @Test
    void ValidarEliminacionExitosa()
    {
        var asociacion = new AsociacionDTO();

        var  contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio= new ServicioEliminarContrato(contratoRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.any())).thenReturn(asociacion);

        var id =servicio.ejecutar(1L);

        Mockito.verify(contratoRepositorioComando,Mockito.times(1)).eliminar(1L);

        Assertions.assertEquals(1L,id);
    }

    @Test
    void ValidarEliminacionNoExitosa()
    {
        var  contratoRepositorioComando = Mockito.mock(ContratoRepositorioComando.class);
        var  asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);

        var servicio= new ServicioEliminarContrato(contratoRepositorioComando, asociacionRepositorioConsulta);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.any())).thenReturn(null);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1,
                Assertions.assertThrows(NullPointerException.class,() -> servicio.ejecutar(1L)).getMessage());
    }
}
