package co.edu.uco.arquisw.dominio.transversal.validador;

public class ValidarObjeto {
    private ValidarObjeto() {
    }

    public static <T> boolean esNulo(T object) {
        return object == null;
    }

    public static <T> T obtenerValorPorDefecto(T objeto, T valorPorDefecto) {
        return esNulo(objeto) ? valorPorDefecto : objeto;
    }
}