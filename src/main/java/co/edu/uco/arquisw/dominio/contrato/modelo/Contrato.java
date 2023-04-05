package co.edu.uco.arquisw.dominio.contrato.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class Contrato {
    private String rutaArchivo;

    private Contrato(String rutaArchivo) {
        setRutaArchivo(rutaArchivo);
    }

    public static Contrato crear(String rutaArchivo) {
        return new Contrato(rutaArchivo);
    }

    public void setRutaArchivo(String rutaArchivo) {
        ValidarTexto.validarObligatorio(rutaArchivo, Mensajes.RUTA_ARCHIVO_CONTRATO_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronURLEsValido(rutaArchivo, Mensajes.PATRON_RUTA_ARCHIVO_CONTRATO_NO_ES_VALIDO);

        this.rutaArchivo = rutaArchivo;
    }
}