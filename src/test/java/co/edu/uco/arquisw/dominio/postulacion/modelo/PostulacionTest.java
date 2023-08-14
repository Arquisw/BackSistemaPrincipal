package co.edu.uco.arquisw.dominio.postulacion.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class PostulacionTest
{
    @Test
    void validarCreacionExitosa()
    {
        var seleccionado = false;
        var rechazado = false;
        var fecha = LocalDate.now();
        var rol = "Analista";

        var postulacion = Postulacion.crear(List.of(rol),seleccionado, rechazado);

        Assertions.assertEquals(seleccionado, postulacion.isSeleccionado());
        Assertions.assertEquals(fecha, postulacion.getFecha());
    }
}