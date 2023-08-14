package co.edu.uco.arquisw.dominio.postulacion.modelo;

import lombok.Getter;

@Getter
public class MotivoRechazoPostulacion {
    private String motivo;

    private MotivoRechazoPostulacion(String motivo) {
        this.motivo = motivo;
    }

    public static MotivoRechazoPostulacion crear(String motivo) {
        return new MotivoRechazoPostulacion(motivo);
    }
}
