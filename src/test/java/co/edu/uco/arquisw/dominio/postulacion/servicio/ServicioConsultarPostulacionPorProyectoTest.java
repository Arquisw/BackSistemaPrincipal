package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioConsultarPostulacionPorProyectoTest {
    @Test
    void validarConsultaPostulacionPorProyectoIdExitosa() {
        var postulacionDto = new PostulacionDTO();
        var proyectoDto = new ProyectoDTO();

        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarPostulacionPorProyecto(postulacionRepositorioConsulta, necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(proyectoDto);

        servicio.ejecutar(NumeroConstante.UNO);

        Mockito.verify(postulacionRepositorioConsulta, Mockito.times(1)).consultarPostulacionesPorProyecto(NumeroConstante.UNO);
    }

    @Test
    void consultaPorProyectoFallida() {
        var postulacionRepositorioConsulta = Mockito.mock(PostulacionRepositorioConsulta.class);
        var necesidadRepositorioConsulta = Mockito.mock(NecesidadRepositorioConsulta.class);

        var servicio = new ServicioConsultarPostulacionPorProyecto(postulacionRepositorioConsulta, necesidadRepositorioConsulta);

        Mockito.when(necesidadRepositorioConsulta.consultarProyectoPorId(Mockito.anyLong())).thenReturn(null);

        Assertions.assertEquals(Mensajes.obtenerNoExisteProyectoConId(NumeroConstante.UNO),
                Assertions.assertThrows(NullPointerException.class, () ->
                        servicio.ejecutar(NumeroConstante.UNO)
                ).getMessage());
    }
}