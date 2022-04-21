package co.edu.uco.arquisw.dominio.utilitario;

public class UtilTexto
{
    private static final String LETRAS_Y_ESPACIOS = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$";
    private static final String ALFANUMERICO = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ .-_+*/#$!=,;?@0123456789]*$";
    private static final String CORREO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String NIT = "^([0-9]{5,15}-[0-9]{1})?$";
    private static final String CLAVE = "^(?=.*[a-z])(?=.*[A-Z])(?=.*?[0-9]).{8,}$";
    private static final String URL = "^(ftp|http|https):\\/\\/[^ \"]+$";
    private static final String URL_ID = "^((\\d{8})|(\\d{10})|(\\d{11})|(\\d{6}-\\d{5}))?$";
    public static final String VACIO = "";

    private UtilTexto()
    {

    }

    public static boolean cadenaEsNula(String string)
    {
        return UtilObjeto.esNulo(string);
    }

    public static String obtenerValorPorDefecto(String string)
    {
        return UtilObjeto.obtenerValorPorDefecto(string, "");
    }

    public static String aplicarTrim(String string)
    {
        return obtenerValorPorDefecto(string.trim());
    }

    public static boolean cadenaEstaVacia(String string)
    {
        String newString = "";

        if(!cadenaEsNula(string))
        {
            newString = string;
        }

        return "".equals(aplicarTrim(newString));
    }

    public static boolean longitudMinimaValida(String string, int minimumLength)
    {
        return UtilNumero.numeroEsMayorOIgual(aplicarTrim(string).length(), minimumLength);
    }

    public static boolean longitudMaximaValida(String string, int maximumLength)
    {
        return aplicarTrim(string).length() <= maximumLength;
    }

    public static boolean longitudEsValida(String string, int minimumLength, int maximumLength)
    {
        return longitudMinimaValida(string, minimumLength) && longitudMaximaValida( string, maximumLength);
    }

    public static boolean cadenaAceptaElPatron(String string, String pattern)
    {
        return aplicarTrim(string).matches(pattern);
    }

    public static boolean cadenaLetrasYEspacios(String string)
    {
        return cadenaAceptaElPatron(string, LETRAS_Y_ESPACIOS);
    }

    public static boolean cadenaAlfanumerica(String string)
    {
        return cadenaAceptaElPatron(string, ALFANUMERICO);
    }

    public static boolean cadenaCorreo(String string)
    {
        return cadenaAceptaElPatron(string, CORREO);
    }

    public static boolean cadenaClave(String string)
    {
        return cadenaAceptaElPatron(string, CLAVE);
    }

    public static boolean cadenaNIT(String string)
    {
        return cadenaAceptaElPatron(string, NIT);
    }

    public static boolean cadenaURL(String string)
    {
        return cadenaAceptaElPatron(string, URL);
    }

    public static boolean cadenaID(String string)
    {
        return cadenaAceptaElPatron(string, URL_ID);
    }
}