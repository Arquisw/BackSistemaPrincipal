package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EstadoProyectoTest {
    @Test
    void validarCreacionExitosa() {
        String nombre = "En Desarrollo";

        var estadoProyecto = EstadoProyecto.crear(nombre);

        Assertions.assertEquals(nombre, estadoProyecto.getNombre());
    }

    @Test
    void validarCampoFaltante() {
        String nombre = "";

        Assertions.assertEquals(Mensajes.NOMBRE_ESTADO_PROYECTO_NO_PUEDE_ESTAR_VACIO, Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                EstadoProyecto.crear(nombre)).getMessage());
    }

    @Test
    void validarPatronesIncorrectas() {
        String nombre = "En Desarroll-";

        Assertions.assertEquals(Mensajes.PATRON_NOMBRE_ESTADO_PROYECTO_NO_ES_VALIDO, Assertions.assertThrows(PatronExcepcion.class, () ->
                EstadoProyecto.crear(nombre)).getMessage());
    }
}