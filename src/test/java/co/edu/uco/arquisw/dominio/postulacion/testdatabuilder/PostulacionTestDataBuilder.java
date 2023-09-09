package co.edu.uco.arquisw.dominio.postulacion.testdatabuilder;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;

import java.time.LocalDate;
import java.util.List;

public class PostulacionTestDataBuilder {

    private LocalDate fecha;
    private boolean seleccionado;
    private boolean rechazado;
    private String rol;

    public PostulacionTestDataBuilder() {
        this.seleccionado = false;
        this.rechazado = false;
        this.rol = "anilista";
    }

    public Postulacion build() {
        return Postulacion.crear(List.of(rol), seleccionado, rechazado);
    }
}