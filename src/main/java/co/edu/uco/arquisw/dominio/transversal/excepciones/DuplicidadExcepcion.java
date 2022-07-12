package co.edu.uco.arquisw.dominio.transversal.excepciones;

import java.io.Serial;

public class DuplicidadExcepcion extends RuntimeException
{
    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicidadExcepcion(String message)
    {
        super(message);
    }
}