package co.edu.uco.arquisw.dominio.postulacion.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class SeleccionTest
{
    @Test
    void validarCreacionExitosa()
    {
        var fecha = LocalDate.now();

        var seleccion = Seleccion.crear();

        Assertions.assertEquals(fecha, seleccion.getFecha());
    }
}