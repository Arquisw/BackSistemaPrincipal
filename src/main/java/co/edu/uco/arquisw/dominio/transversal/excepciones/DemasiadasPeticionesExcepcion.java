package co.edu.uco.arquisw.dominio.transversal.excepciones;

import java.io.Serial;

public class DemasiadasPeticionesExcepcion extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DemasiadasPeticionesExcepcion(String message) {
        super(message);
    }
}