package co.edu.uco.arquisw.dominio.transversal.excepciones;

import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;

import java.io.Serial;

public class PatronExcepcion extends RuntimeException {
    @Serial
    private static final long serialVersionUID = NumeroConstante.UNO;

    public PatronExcepcion(String message) {
        super(message);
    }
}