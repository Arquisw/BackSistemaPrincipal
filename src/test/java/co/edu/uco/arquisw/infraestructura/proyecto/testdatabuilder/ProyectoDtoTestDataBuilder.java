package co.edu.uco.arquisw.infraestructura.proyecto.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.ProyectoComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.TipoConsultoriaComando;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.RolTestDataBuilder;

import java.util.List;

public class ProyectoDtoTestDataBuilder {

    private String nombre;
    private String descripcion;
    private List<TipoConsultoriaComando> tiposConsultoria;

    public ProyectoDtoTestDataBuilder()
    {
        this.nombre= "NETFLIX";
        this.descripcion = "STREAMING";
        this.tiposConsultoria = List.of(new TipoDeConsultoriaDtoDataBuilder().build());
    }

    public ProyectoComando build()
    {
        return new ProyectoComando(nombre,descripcion,tiposConsultoria);
    }
}
