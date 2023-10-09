package co.edu.uco.arquisw.dominio.contrato.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContratoTest {

    @Test
    void validarCreacionContratoExitosa() {
        String rutaArchivo = "http://www.direccion.org/ejemplo/item.html";

        Contrato contrato = Contrato.crear(rutaArchivo);

        Assertions.assertEquals(rutaArchivo, contrato.getRutaArchivo());
    }

    @Test
    void validarCamposFaltante() {
        Assertions.assertEquals(Mensajes.RUTA_ARCHIVO_CONTRATO_NO_PUEDE_ESTAR_VACIO, Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Contrato.crear("")).getMessage());
    }

    @Test
    void validarPatronIncorrectoFaltante() {
        Assertions.assertEquals(Mensajes.PATRON_RUTA_ARCHIVO_CONTRATO_NO_ES_VALIDO, Assertions.assertThrows(PatronExcepcion.class, () ->
                Contrato.crear("ttp://www.direccion.org/ejemplo/item.html")).getMessage());
    }
}