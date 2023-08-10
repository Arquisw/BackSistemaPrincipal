package co.edu.uco.arquisw.dominio.proyecto.modelo;

import lombok.Getter;

@Getter
public class Necesidad {
    private final EstadoNecesidad estado;
    private final Proyecto proyecto;

    private Necesidad(EstadoNecesidad estado, Proyecto proyecto) {
        this.estado = estado;
        this.proyecto = proyecto;
    }

    public static Necesidad crear(EstadoNecesidad estado, Proyecto proyecto) {
        return new Necesidad(estado, proyecto);
    }
}