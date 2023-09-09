package co.edu.uco.arquisw.dominio.proyecto.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NecesidadTest {
    @Test
    void validarCreacionExitosa() {
        String nombre = "Facebook";
        String descripcion = "Red Social";
        String estado = "En Desarrollo";
        String tipo = "Ingeniería de Requisitos";
        String rutaArchivo = "http://www.direccion.org/ejemplo/item.html";
        String estadoN = "En Espera";

        var estadoProyecto = EstadoProyecto.crear(estado);
        var tipoConsultoria = TipoConsultoria.crear(tipo);
        var estadoNecesidad = EstadoNecesidad.crear(estadoN);

        var proyecto = Proyecto.crear(nombre, descripcion, estadoProyecto, List.of(tipoConsultoria));
        var necesidad = Necesidad.crear(estadoNecesidad, proyecto);

        Assertions.assertEquals(nombre, necesidad.getProyecto().getNombre());
        Assertions.assertEquals(descripcion, necesidad.getProyecto().getDescripcion());
        Assertions.assertEquals(estado, necesidad.getProyecto().getEstado().getNombre());
        Assertions.assertEquals(tipo, necesidad.getProyecto().getTiposConsultoria().get(0).getNombre());
    }
}