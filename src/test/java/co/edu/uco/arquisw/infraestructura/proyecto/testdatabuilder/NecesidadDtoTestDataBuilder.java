package co.edu.uco.arquisw.infraestructura.proyecto.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.NecesidadComando;
import co.edu.uco.arquisw.aplicacion.proyecto.comando.ProyectoComando;

public class NecesidadDtoTestDataBuilder {
    private String rutaArchivo;
    private ProyectoComando proyecto;

    public NecesidadDtoTestDataBuilder()
    {
        this.rutaArchivo = "http://www.direccion.org/ejemplo/item.html";
        this.proyecto = new ProyectoDtoTestDataBuilder().build();
    }

    public NecesidadComando build()
    {
        return new NecesidadComando(rutaArchivo,proyecto);
    }
}
