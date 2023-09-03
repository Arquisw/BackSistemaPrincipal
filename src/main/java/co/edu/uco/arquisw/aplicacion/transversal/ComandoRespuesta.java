package co.edu.uco.arquisw.aplicacion.transversal;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ComandoRespuesta<T> {
    private T valor;

    public ComandoRespuesta(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }
}