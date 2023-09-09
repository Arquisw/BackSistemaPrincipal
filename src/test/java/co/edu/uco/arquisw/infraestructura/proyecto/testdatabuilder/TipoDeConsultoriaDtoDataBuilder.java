package co.edu.uco.arquisw.infraestructura.proyecto.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.TipoConsultoriaComando;

public class TipoDeConsultoriaDtoDataBuilder {
    private String nombre;

    public TipoDeConsultoriaDtoDataBuilder() {
        this.nombre = "SQA";
    }

    public TipoConsultoriaComando build() {
        return new TipoConsultoriaComando(nombre);
    }
}