package co.edu.uco.arquisw.dominio.transversal.excepciones;

import java.io.Serial;

public class TiempoVencidoExcepcion extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TiempoVencidoExcepcion(String message) {
        super(message);
    }
}