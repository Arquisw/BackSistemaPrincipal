package co.edu.uco.arquisw.dominio.transversal.excepciones;

import java.io.Serial;

public class TecnicoExcepcion extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TecnicoExcepcion(String message) {
        super(message);
    }
}