package co.edu.uco.arquisw.dominio.proyecto.testdatabuilder;

import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Proyecto;

public class NesecidadTestDataBuilder
{
    private final EstadoNecesidad estado;
    private final Proyecto proyecto;

    public NesecidadTestDataBuilder()
    {
        this.estado = new EstadoNesecidadTestDataBuilder().build();
        this.proyecto = new ProyectoTestDataBuilder().build();
    }

    public Necesidad build()
    {
        return Necesidad.crear(estado,proyecto);
    }
}
