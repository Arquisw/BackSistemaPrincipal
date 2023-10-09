package co.edu.uco.arquisw.dominio.transversal.excepciones;

import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;

import java.io.Serial;

public class DemasiadasPeticionesExcepcion extends RuntimeException {
    @Serial
    private static final long serialVersionUID = NumeroConstante.UNO;

    public DemasiadasPeticionesExcepcion(String message) {
        super(message);
    }
}