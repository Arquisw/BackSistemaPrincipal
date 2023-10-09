package co.edu.uco.arquisw.dominio.transversal.excepciones;

import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;

import java.io.Serial;

public class ValorObligatorioExcepcion extends RuntimeException {
    @Serial
    private static final long serialVersionUID = NumeroConstante.UNO;

    public ValorObligatorioExcepcion(String message) {
        super(message);
    }
}