package co.edu.uco.arquisw.infraestructura.asociacion.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.asociacion.comando.AsociacionComando;

public class AsociacionDtoTestDataBuilder {

    private String nombre;
    private String nit;
    private String numeroContacto;

    public AsociacionDtoTestDataBuilder() {
        this.nombre = "Uco";
        this.nit = "12345678-1";
        this.numeroContacto = "3125678170";
    }

    public AsociacionComando build()
    {
        return new AsociacionComando(nombre,nit,numeroContacto);
    }
}
