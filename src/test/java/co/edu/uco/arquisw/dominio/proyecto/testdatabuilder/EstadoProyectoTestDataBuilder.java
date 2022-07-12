package co.edu.uco.arquisw.dominio.proyecto.testdatabuilder;


import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;

public class EstadoProyectoTestDataBuilder
{
    private final String nombre;

    public EstadoProyectoTestDataBuilder() {
        this.nombre = "En Desarrollo";
    }

    public EstadoProyecto build ()
    {
        return EstadoProyecto.crear(nombre);
    }
}
