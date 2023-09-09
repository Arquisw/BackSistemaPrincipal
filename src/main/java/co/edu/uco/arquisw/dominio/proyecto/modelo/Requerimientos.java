package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class Requerimientos {
    private String rutaArchivo;

    private Requerimientos(String rutaArchivo) {
        setRutaArchivo(rutaArchivo);
    }

    public static Requerimientos crear(String rutaArchivo) {
        return new Requerimientos(rutaArchivo);
    }

    public void setRutaArchivo(String rutaArchivo) {
        ValidarTexto.validarObligatorio(rutaArchivo, Mensajes.RUTA_ARCHIVO_NECESIDAD_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronURLEsValido(rutaArchivo, Mensajes.PATRON_RUTA_ARCHIVO_NECESIDAD_NO_ES_VALIDO);

        this.rutaArchivo = rutaArchivo;
    }
}