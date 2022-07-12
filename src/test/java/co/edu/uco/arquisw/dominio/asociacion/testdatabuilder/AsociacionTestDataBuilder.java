package co.edu.uco.arquisw.dominio.asociacion.testdatabuilder;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;

public class AsociacionTestDataBuilder
{
    private final String nombre;
    private final String nit;
    private final String numeroContacto;

    public AsociacionTestDataBuilder()
    {
        this.nombre = "Uco";
        this.nit = "12345678-1";
        this.numeroContacto = "3125678170";
    }

    public Asociacion build ()
    {
        return Asociacion.crear(nombre, nit, numeroContacto);
    }
}
