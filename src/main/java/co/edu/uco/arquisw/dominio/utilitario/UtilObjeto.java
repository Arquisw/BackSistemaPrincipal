package co.edu.uco.arquisw.dominio.utilitario;

public class UtilObjeto
{
    private UtilObjeto()
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