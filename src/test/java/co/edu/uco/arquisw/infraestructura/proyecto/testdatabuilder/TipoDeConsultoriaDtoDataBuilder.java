package co.edu.uco.arquisw.infraestructura.proyecto.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.TipoConsultoriaComando;

public class TipoDeConsultoriaDtoDataBuilder {
    private String nombre;

    public TipoDeConsultoriaDtoDataBuilder()
    {
        this.nombre = "Ingeniria de Requisitos";
    }

    public TipoConsultoriaComando build()
    {
        return new TipoConsultoriaComando(nombre);
    }
}
