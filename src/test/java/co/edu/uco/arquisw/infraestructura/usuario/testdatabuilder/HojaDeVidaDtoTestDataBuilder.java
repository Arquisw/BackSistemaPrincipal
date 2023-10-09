package co.edu.uco.arquisw.infraestructura.usuario.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.usuario.comando.HojaVidaComando;

public class HojaDeVidaDtoTestDataBuilder {
    private String ruta;

    public HojaDeVidaDtoTestDataBuilder() {
        this.ruta = "http://www.direccion.org/ejemploCV2/item.html";
    }

    public HojaVidaComando build() {
        return new HojaVidaComando(ruta);
    }
}