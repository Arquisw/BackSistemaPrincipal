package co.edu.uco.arquisw.dominio.transversal.validador;

import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;

public class ValidarTexto {
    private static final String LETRAS_Y_ESPACIOS = "^[a-zA-ZáéíóúÁÉÍÓÚÄëËïÏöÖüÜñÑ ]*$";
    private static final String ALFANUMERICO = "^[a-zA-ZáéíóúäÄëËïÏöÖüÜÁÉÍÓÚñÑ .\\-_+*/#$!=,;()\"%':?@0-9]*$";
    private static final String CORREO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String NIT = "^([0-9]{5,15}-[0-9]{1})?$";
    private static final String NUMERO_TELEFONO = "^(\\(\\+?\\d{2,3}\\)[\\*|\\s|\\-|\\.]?(([\\d][\\*|\\s|\\-|\\.]?){6})(([\\d][\\s|\\-|\\.]?){2})?|(\\+?[\\d][\\s|\\-|\\.]?){8}(([\\d][\\s|\\-|\\.]?){2}(([\\d][\\s|\\-|\\.]?){2})?)?)$";
    private static final String CLAVE = "^(?=.*[a-z])(?=.*[A-Z])(?=.*?[0-9]).{8,}$";
    private static final String URL = "^(ftp|http|https):\\/\\/[^ \"]+$";
    private static final String URL_ID = "^((\\d{8})|(\\d{10})|(\\d{11})|(\\d{6}-\\d{5}))?$";

    private ValidarTexto() {
    }

    public static void validarObligatorio(String valor, String mensaje) {
        if (cadenaEstaVacia(valor)) {
            throw new ValorObligatorioExcepcion(mensaje);
        }
    }

    public static void validarPatronAlfanumericoEsValido(String valor, String mensaje) {
        if (!cadenaEsAlfanumerica(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarPatronTextoEsValido(String valor, String mensaje) {
        if (!cadenaLetrasYEspacios(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarCorreoEsValido(String valor, String mensaje) {
        if (!cadenaCorreo(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarClaveEsValida(String valor, String mensaje) {
        if (!cadenaClave(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarPatronNITEsValido(String valor, String mensaje) {
        if (!cadenaNIT(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarPatronNumeroEsValido(String valor, String mensaje) {
        if (!cadenaNumeroTelefono(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarPatronURLEsValido(String valor, String mensaje) {
        if (!cadenaURL(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static boolean cadenaEstaVacia(String string) {
        return cadenaEsNula(string) || "".equals(aplicarTrim(string));
    }

    public static boolean cadenaEsNula(String string) {
        return ValidarObjeto.esNulo(string);
    }

    public static String aplicarTrim(String string) {
        return obtenerValorPorDefecto(string.trim());
    }

    public static String obtenerValorPorDefecto(String string) {
        return ValidarObjeto.obtenerValorPorDefecto(string, "");
    }

    public static boolean cadenaAceptaElPatron(String string, String pattern) {
        return aplicarTrim(string).matches(pattern);
    }

    public static boolean cadenaLetrasYEspacios(String string) {
        return cadenaAceptaElPatron(string, LETRAS_Y_ESPACIOS);
    }

    public static boolean cadenaEsAlfanumerica(String string) {
        return cadenaAceptaElPatron(string, ALFANUMERICO);
    }

    public static boolean cadenaCorreo(String string) {
        return cadenaAceptaElPatron(string, CORREO);
    }

    public static boolean cadenaClave(String string) {
        return cadenaAceptaElPatron(string, CLAVE);
    }

    public static boolean cadenaNIT(String string) {
        return cadenaAceptaElPatron(string, NIT);
    }

    public static boolean cadenaNumeroTelefono(String string) {
        return cadenaAceptaElPatron(string, NUMERO_TELEFONO);
    }

    public static boolean cadenaURL(String string) {
        return cadenaAceptaElPatron(string, URL);
    }

    public static boolean cadenaID(String string) {
        return cadenaAceptaElPatron(string, URL_ID);
    }
}