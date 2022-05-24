package co.edu.uco.arquisw.dominio.formateador;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TiempoFormateador
{
    private static final String FORMATO_HH_MM_SS = "HH:mm:ss";

    private TiempoFormateador()
    {

    }

    public static LocalTime obtenerTiempo(String textoTiempo)
    {
        DateTimeFormatter patron = DateTimeFormatter.ofPattern(FORMATO_HH_MM_SS);

        return LocalTime.parse(textoTiempo, patron);
    }

    public static String obtenerTextoTiempo(LocalTime tiempo)
    {
        DateTimeFormatter patron = DateTimeFormatter.ofPattern(FORMATO_HH_MM_SS);

        return patron.format(tiempo);
    }
}