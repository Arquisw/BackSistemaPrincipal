package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.proyecto.testdatabuilder.EstadoProyectoTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ProyectoTest
{
    @Test
    void validarCreacionExitosa()
    {
        String nombre = "Facebook";
        String descripcion = "Red Social";
        String estado = "En Desarrollo";
        String tipo = "Ingeniería de Requisitos";

        var estadoProyecto = EstadoProyecto.crear(estado);
        var tipoConsultoria = TipoConsultoria.crear(tipo);

        var proyecto = Proyecto.crear(nombre, descripcion, estadoProyecto, List.of(tipoConsultoria));

        Assertions.assertEquals(nombre, proyecto.getNombre());
        Assertions.assertEquals(descripcion, proyecto.getDescripcion());
        Assertions.assertEquals(estado, proyecto.getEstado().getNombre());
        Assertions.assertEquals(tipo, proyecto.getTiposConsultoria().get(0).getNombre());
    }

    @Test
    void validarCamposFaltantes()
    {
        List<TipoConsultoria> tipoConsultorio = new ArrayList<>();
        TipoConsultoria tipo =  TipoConsultoria.crear("Ingeniería de Requisitos");
        tipoConsultorio.add(tipo);
        var estadoProyecto = new EstadoProyectoTestDataBuilder().build();

        Assertions.assertEquals(Mensajes.NOMBRE_PROYECTO_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Proyecto.crear("","Red Social",estadoProyecto,tipoConsultorio)).getMessage());

        Assertions.assertEquals(Mensajes.DESCRIPCION_ESTADO_PROYECTO_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Proyecto.crear("Facebook","",estadoProyecto,tipoConsultorio)).getMessage());
    }
    @Test
    void validarPatronIncorrecto()
    {
        List<TipoConsultoria> tipoConsultorio = new ArrayList<>();
        TipoConsultoria tipo =  TipoConsultoria.crear("Ingeniería de Requisitos");
        tipoConsultorio.add(tipo);
        var estadoProyecto = new EstadoProyectoTestDataBuilder().build();

        Assertions.assertEquals(Mensajes.PATRON_NOMBRE_PROYECTO_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Proyecto.crear("face-book","Red Social",estadoProyecto,tipoConsultorio)).getMessage());

        Assertions.assertEquals(Mensajes.PATRON_DESCRIPCION_PROYECTO_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
               Proyecto.crear("Facebook","Red-Social",estadoProyecto,tipoConsultorio)).getMessage());
    }
}