package co.edu.uco.arquisw.dominio.validador;

public class ValidarObjeto
{
    private ValidarObjeto()
    {

    }

    public static <T> boolean esNulo(T object)
    {
        return object == null;
    }

    public static <T> T obtenerValorPorDefecto(T object, T defaultValue)
    {
        return esNulo(object) ? defaultValue : object;
    }
}