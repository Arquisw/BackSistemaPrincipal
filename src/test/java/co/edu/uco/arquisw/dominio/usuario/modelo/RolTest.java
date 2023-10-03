package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RolTest {
    @Test
    void validarCreacionExitosa() {
        String nombre = "Administrasdor";

        Rol rol = Rol.crear(nombre);

        Assertions.assertEquals(nombre, rol.getNombre());
    }

    @Test
    void validarCampoFaltante() {
        String nombre = "";

        Assertions.assertEquals(Mensajes.NOMBRE_ROL_VACIO, Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Rol.crear(nombre)).getMessage());
    }
}
