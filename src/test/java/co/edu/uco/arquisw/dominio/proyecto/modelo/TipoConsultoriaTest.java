package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TipoConsultoriaTest
{
    @Test
    void validarCreacionExitosa()
    {
        String nombre = "Ingeniería de Requisitos";

        var tipoConsultoria = TipoConsultoria.crear(nombre);

        Assertions.assertEquals(nombre, tipoConsultoria.getNombre());
    }
    @Test
    void validarCampoFaltante()
    {
        String nombre = "";

        Assertions.assertEquals(Mensajes.NOMBRE_TIPO_CONSULTORIA_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                TipoConsultoria.crear(nombre)).getMessage());
    }
    @Test
    void validarPatronesIncorrectas()
    {
        String nombre = "Ingeniería de Requisito-";

        Assertions.assertEquals(Mensajes.PATRON_NOMBRE_TIPO_CONSULTORIA_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                TipoConsultoria.crear(nombre)).getMessage());
    }
}