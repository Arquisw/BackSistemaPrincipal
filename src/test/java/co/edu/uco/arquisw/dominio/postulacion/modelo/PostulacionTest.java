package co.edu.uco.arquisw.dominio.postulacion.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class PostulacionTest
{
    @Test
    void validarCreacionExitosa()
    {
        var seleccionado = false;
        var fecha = LocalDate.now();
        var rol = "Analista";

        var postulacion = Postulacion.crear(rol,seleccionado);

        Assertions.assertEquals(seleccionado, postulacion.isSeleccionado());
        Assertions.assertEquals(fecha, postulacion.getFecha());
    }
}