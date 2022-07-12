package co.edu.uco.arquisw.dominio.transversal.formateador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaFormateador
{
    private static final String FORMATO_YYYY_MM_DD = "yyyy/MM/dd";

    private FechaFormateador()
    {

    }

    public static LocalDate obtenerFechaActual()
    {
        return LocalDate.now();
    }

    public static LocalDate obtenerFecha(String fechaTexto)
    {
        DateTimeFormatter patron = DateTimeFormatter.ofPattern(FORMATO_YYYY_MM_DD);

        return LocalDate.parse(fechaTexto, patron);
    }

    public static String obtenerFechaTexto(LocalDate fecha)
    {
        DateTimeFormatter patron = DateTimeFormatter.ofPattern(FORMATO_YYYY_MM_DD);

        return patron.format(fecha);
    }
}