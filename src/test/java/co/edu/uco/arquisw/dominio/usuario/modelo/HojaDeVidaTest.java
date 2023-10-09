package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HojaDeVidaTest {

    @Test
    void validarCreacionHojaDeVidaExitosa() {
        String rutaArchivo = "http://www.direccion.org/ejemplo/item.html";

        HojaDeVidaPersona hojaDeVidaPersona = HojaDeVidaPersona.crear(rutaArchivo);

        Assertions.assertEquals(rutaArchivo, hojaDeVidaPersona.getRutaArchivo());
    }

    @Test
    void validarCamposFaltante() {
        Assertions.assertEquals(Mensajes.RUTA_ARCHIVO_HOJA_DE_VIDA_NO_PUEDE_ESTAR_VACIO, Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                HojaDeVidaPersona.crear("")).getMessage());
    }

    @Test
    void validarPatronIncorrectoFaltante() {
        Assertions.assertEquals(Mensajes.PATRON_RUTA_ARCHIVO_HOJA_DE_VIDA_NO_ES_VALIDO, Assertions.assertThrows(PatronExcepcion.class, () ->
                HojaDeVidaPersona.crear("ttp://www.direccion.org/ejemplo/item.html")).getMessage());
    }
}