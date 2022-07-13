package co.edu.uco.arquisw.dominio.postulacion.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PostulacionTest
{
    @Test
    void validarCreacionExitosa()
    {
        var seleccionado = false;
        var fecha = LocalDate.now();

        var postulacion = Postulacion.crear(seleccionado);

        Assertions.assertEquals(seleccionado, postulacion.isSeleccionado());
        Assertions.assertEquals(fecha, postulacion.getFecha());
    }
}