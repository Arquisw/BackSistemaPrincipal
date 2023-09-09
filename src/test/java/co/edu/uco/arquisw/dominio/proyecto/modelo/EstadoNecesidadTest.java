package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EstadoNecesidadTest {
    @Test
    void validarCreacionExitosa() {
        String nombre = "En Espera";

        var estadoNecesidad = EstadoNecesidad.crear(nombre);

        Assertions.assertEquals(nombre, estadoNecesidad.getNombre());
    }

    @Test
    void validarCampoFaltante() {
        String nombre = "";

        Assertions.assertEquals(Mensajes.NOMBRE_ESTADO_NECESIDAD_NO_PUEDE_ESTAR_VACIO, Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                EstadoNecesidad.crear(nombre)).getMessage());
    }

    @Test
    void validarPatronesIncorrectas() {
        String nombre = "En Esper-";

        Assertions.assertEquals(Mensajes.PATRON_NOMBRE_ESTADO_NECESIDAD_NO_ES_VALIDO, Assertions.assertThrows(PatronExcepcion.class, () ->
                EstadoNecesidad.crear(nombre)).getMessage());
    }
}