package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.dto.EstadoNecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.servicio.ServicioEliminarNecesidad;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarAsociacionTest {
    @Test
    void ValidarEliminacionExitosa()
    {
        var estado = new EstadoNecesidadDTO();
        estado.setNombre(TextoConstante.ESTADO_EN_ESPERA);
        var necesidad = new NecesidadDTO();
        necesidad.setEstado(estado);
        var asociacion =new AsociacionDTO();

        var   asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var   necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var   necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);

        var servicio = new ServicioEliminarNecesidad(asociacionRepositorioConsulta,necesidadRepositorioConsulta,necesidadRepositorioComando);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(asociacion);
        Mockito.when(necesidadRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(necesidad);

        var id =servicio.ejecutar(1L);

        Mockito.verify(necesidadRepositorioComando,Mockito.times(1)).eliminar(1L);

        Assertions.assertEquals(1L,id);
    }
    @Test
    void ValidarEliminacionFallidaNoExisteAsociacion()
    {
        var estado = new EstadoNecesidadDTO();
        estado.setNombre(TextoConstante.ESTADO_EN_ESPERA);
        var necesidad = new NecesidadDTO();
        necesidad.setEstado(estado);

        var   asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var   necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var   necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);

        var servicio = new ServicioEliminarNecesidad(asociacionRepositorioConsulta,necesidadRepositorioConsulta,necesidadRepositorioComando);

        Mockito.when(necesidadRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(necesidad);

        Assertions.assertEquals(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + 1,
                Assertions.assertThrows(NullPointerException.class,() -> servicio.ejecutar(1L)).getMessage());
    }
    @Test
    void ValidarEliminacionFallidaExisteUnaNecesidad()
    {
        var estado = new EstadoNecesidadDTO();
        estado.setNombre(TextoConstante.ESTADO_APROBADO);
        var necesidad = new NecesidadDTO();
        necesidad.setEstado(estado);
        var asociacion =new AsociacionDTO();

        var   asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var   necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);
        var   necesidadRepositorioComando = Mockito.mock(NecesidadRepositorioComando.class);

        var servicio = new ServicioEliminarNecesidad(asociacionRepositorioConsulta,necesidadRepositorioConsulta,necesidadRepositorioComando);

        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(asociacion);
        Mockito.when(necesidadRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(necesidad);

        Assertions.assertEquals(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_APROBADA_PARA_SU_DESARROLLO ,
                Assertions.assertThrows(AutorizacionExcepcion.class,() -> servicio.ejecutar(1L)).getMessage());
    }
}
