package co.edu.uco.arquisw.dominio.utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFecha
{
    private static final String FECHA_DEFECTO = "2022/01/01";
    private static final String FORMATO_YYYY_MM_DD = "yyyy/mm/dd";

    private UtilFecha()
    {

    }

    public static Date obtenerFechaPorDefecto(Date fecha, Date valorPorDefecto)
    {
        return UtilObjeto.obtenerValorPorDefecto(fecha, valorPorDefecto);
    }

    public static Date obtenerFechaActual()
    {
        return new Date();
    }

    public static Date obtenerFechaPorDefecto()
    {
        return formatearFecha(FECHA_DEFECTO, FORMATO_YYYY_MM_DD);
    }

    public static Date obtenerFechaPorDefecto(Date fecha)
    {
        return formatearFecha(FECHA_DEFECTO, FORMATO_YYYY_MM_DD);
    }

    public static Date formatearFecha(String fechaTexto, String formato)
    {
        try
        {
            SimpleDateFormat formateador = new SimpleDateFormat(formato);

            return formateador.parse(fechaTexto);
        }
        catch(ParseException excepcion)
        {
            throw new IllegalArgumentException(excepcion.getMessage());
        }
        catch(Exception excepcion)
        {

            throw new IllegalArgumentException(excepcion.getMessage());
        }
    }
}