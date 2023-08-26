package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class MotivoRechazoNecesidad {
    private String motivo;

    private MotivoRechazoNecesidad(String motivo) {
        setMotivo(motivo);
    }

    public static MotivoRechazoNecesidad crear(String motivo) {
        return new MotivoRechazoNecesidad(motivo);
    }

    private void setMotivo(String motivo) {
        ValidarTexto.validarObligatorio(motivo, Mensajes.MOTIVO_RECHAZO_NECESIDAD_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronAlfanumericoEsValido(motivo, Mensajes.PATRON_MOTIVO_RECHAZO_NECESIDAD_NO_ES_VALIDO);

        this.motivo = motivo;
    }
}
