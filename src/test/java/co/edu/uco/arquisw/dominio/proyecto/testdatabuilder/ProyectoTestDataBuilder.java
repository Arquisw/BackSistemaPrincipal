package co.edu.uco.arquisw.dominio.proyecto.testdatabuilder;


import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Proyecto;
import co.edu.uco.arquisw.dominio.proyecto.modelo.TipoConsultoria;

import java.util.List;

public class ProyectoTestDataBuilder {

    private String nombre;
    private String descripcion;
    private EstadoProyecto estado;
    private List<TipoConsultoria> tiposConsultoria;

    public ProyectoTestDataBuilder() {
        this.nombre = "hifive";
        this.descripcion = "red social";
        this.estado = new EstadoProyectoTestDataBuilder().build();
        this.tiposConsultoria = List.of(new TipoDeConsultoriaTestDtaBuilder().build());
    }

    public Proyecto build()
    {
        return Proyecto.crear(nombre,descripcion,estado,tiposConsultoria);
    }
}
