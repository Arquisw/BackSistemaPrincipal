package co.edu.uco.arquisw.dominio.validador;

public class ValidarNumero
{
    private ValidarNumero()
    {

    }

    @SuppressWarnings("unchecked")
    public static <T extends Number> T obtenerNumeroPorDefecto(T numero)
    {
        return (T) ValidarObjeto.obtenerValorPorDefecto(numero, 0);
    }

    public static <T extends Number> boolean numeroEsMayor(T numero, T numeroComparador)
    {
        return obtenerNumeroPorDefecto(numero).doubleValue() > obtenerNumeroPorDefecto(numeroComparador).doubleValue();
    }

    public static <T extends Number> boolean numeroEsMenor(T numero, T numeroComparador)
    {
        return obtenerNumeroPorDefecto(numero).doubleValue() < obtenerNumeroPorDefecto(numeroComparador).doubleValue();
    }

    public static <T extends Number> boolean numeroEsIgual(T numero, T numeroComparador)
    {
        return obtenerNumeroPorDefecto(numero).doubleValue() == obtenerNumeroPorDefecto(numeroComparador).doubleValue();
    }

    public static <T extends Number> boolean numeroEsDiferente(T numero, T numeroComparador)
    {
        return !numeroEsIgual(numero, numeroComparador);
    }

    public static <T extends Number> boolean numeroEsMayorOIgual(T numero, T numeroComparador)
    {
        return numeroEsMayor(numero, numeroComparador) || numeroEsIgual(numero, numeroComparador);
    }

    public static <T extends Number> boolean numeroEsMenorOIgual(T numero, T numeroComparador)
    {
        return numeroEsMenor(numero, numeroComparador) || numeroEsIgual(numero, numeroComparador);
    }

    public static <T extends Number> boolean numeroEstaEntre(T numero, T limiteInferior, T limiteSuperior)
    {
        return numeroEsMayorOIgual(numero, limiteInferior) && numeroEsMenorOIgual(numero, limiteSuperior);
    }
}