package co.edu.uco.arquisw.dominio.proyecto.testdatabuilder;

import co.edu.uco.arquisw.dominio.proyecto.modelo.TipoConsultoria;

public class TipoDeConsultoriaTestDtaBuilder {
    private String nombre;

    public TipoDeConsultoriaTestDtaBuilder() {
        this.nombre = "Ingeniria de Requisitos";
    }

    public TipoConsultoria build ()
    {
        return TipoConsultoria.crear(nombre);
    }
}
