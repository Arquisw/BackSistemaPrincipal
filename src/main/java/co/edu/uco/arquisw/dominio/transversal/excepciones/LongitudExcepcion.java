package co.edu.uco.arquisw.dominio.transversal.excepciones;

import java.io.Serial;

public class LongitudExcepcion extends RuntimeException
{
    @Serial
    private static final long serialVersionUID = 1L;

    public LongitudExcepcion(String message)
    {
        super(message);
    }
}