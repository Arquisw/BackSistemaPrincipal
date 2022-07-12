package co.edu.uco.arquisw.dominio.proyecto.testdatabuilder;

import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;


public class EstadoNesecidadTestDataBuilder
{
    private final String nombre;

    public EstadoNesecidadTestDataBuilder() {
        this.nombre = "En Espera";
    }

    public EstadoNecesidad build ()
    {
        return EstadoNecesidad.crear(nombre);
    }
}
