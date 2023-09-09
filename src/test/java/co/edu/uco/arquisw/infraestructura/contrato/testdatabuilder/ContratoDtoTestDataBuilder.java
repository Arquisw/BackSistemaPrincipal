package co.edu.uco.arquisw.infraestructura.contrato.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.contrato.comando.ContratoComando;

public class ContratoDtoTestDataBuilder {
    private final String rutaArchivo;

    public ContratoDtoTestDataBuilder() {
        this.rutaArchivo = "http://www.direccion.org/ejemplo/item.html";
    }

    public ContratoComando build() {
        return new ContratoComando(rutaArchivo);
    }
}