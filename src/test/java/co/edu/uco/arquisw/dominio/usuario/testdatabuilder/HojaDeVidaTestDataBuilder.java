package co.edu.uco.arquisw.dominio.usuario.testdatabuilder;

import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;

public class HojaDeVidaTestDataBuilder {
    private String rutaArchivo;

    public HojaDeVidaTestDataBuilder()
    {
        this.rutaArchivo = "http://www.direccion.org/ejemplo/item.html";
    }
    public HojaDeVidaPersona build()
    {
        return HojaDeVidaPersona.crear(rutaArchivo);
    }
}
