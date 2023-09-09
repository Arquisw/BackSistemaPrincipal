package co.edu.uco.arquisw.dominio.contrato.testDataBuilder;

import co.edu.uco.arquisw.dominio.contrato.modelo.Contrato;


public class ContratoTestDataBuilder {

    private String rutaArchivo;

    public ContratoTestDataBuilder() {
        this.rutaArchivo = "http://www.direccion.org/ejemplo/item.html";
    }

    public Contrato build() {
        return Contrato.crear(rutaArchivo);
    }
}