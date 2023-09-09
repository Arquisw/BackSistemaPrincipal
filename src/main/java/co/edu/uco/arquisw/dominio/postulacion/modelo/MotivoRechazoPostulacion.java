package co.edu.uco.arquisw.dominio.postulacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class MotivoRechazoPostulacion {
    private String motivo;

    private MotivoRechazoPostulacion(String motivo) {
        setMotivo(motivo);
    }

    public static MotivoRechazoPostulacion crear(String motivo) {
        return new MotivoRechazoPostulacion(motivo);
    }

    private void setMotivo(String motivo) {
        ValidarTexto.validarObligatorio(motivo, Mensajes.MOTIVO_RECHAZO_POSTULACION_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronAlfanumericoEsValido(motivo, Mensajes.PATRON_MOTIVO_RECHAZO_POSTULACION_NO_ES_VALIDO);

        this.motivo = motivo;
    }
}