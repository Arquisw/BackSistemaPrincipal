package co.edu.uco.arquisw.dominio.transversal.excepciones;

import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;

import java.io.Serial;

public class TiempoVencidoExcepcion extends RuntimeException {
    @Serial
    private static final long serialVersionUID = NumeroConstante.UNO;

    public TiempoVencidoExcepcion(String message) {
        super(message);
    }
}