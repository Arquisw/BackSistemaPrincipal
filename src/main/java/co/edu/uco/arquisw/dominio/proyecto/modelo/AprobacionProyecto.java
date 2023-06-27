package co.edu.uco.arquisw.dominio.proyecto.modelo;

import lombok.Getter;

@Getter
public class AprobacionProyecto {
    private final boolean ingenieria;
    private final boolean liderDeEquipo;
    private final boolean directorDeProyecto;


    private AprobacionProyecto(boolean ingenieria, boolean liderDeEquipo, boolean directorDeProyecto) {
        this.ingenieria = ingenieria;
        this.liderDeEquipo = liderDeEquipo;
        this.directorDeProyecto = directorDeProyecto;
    }

    public static AprobacionProyecto crear() {
        return new AprobacionProyecto(false, false, false);
    }

    public static AprobacionProyecto modificar(boolean ingenieria, boolean liderDeEquipo, boolean directorDeProyecto) {
        return new AprobacionProyecto(ingenieria, liderDeEquipo, directorDeProyecto);
    }
}