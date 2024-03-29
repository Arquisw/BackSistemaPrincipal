package co.edu.uco.arquisw.dominio.postulacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Postulacion {
    private LocalDate fecha;
    private List<String> roles;
    private boolean seleccionado;
    private boolean rechazado;

    private Postulacion(List<String> roles, boolean seleccionado, boolean rechazado) {
        setFecha();
        setRoles(roles);
        setSeleccionado(seleccionado);
        setRechazado(rechazado);
    }

    public static Postulacion crear(List<String> roles, boolean seleccionado, boolean rechazado) {
        return new Postulacion(roles, seleccionado, rechazado);
    }

    private void setRoles(List<String> roles) {
        roles.forEach(rol -> {
            ValidarTexto.validarObligatorio(rol, Mensajes.NOMBRE_ROL_VACIO);
            ValidarTexto.validarPatronAlfanumericoEsValido(rol, Mensajes.PATRON_NOMBRE_ROL_INVALIDO);
        });

        this.roles = roles;
    }

    private void setFecha() {
        this.fecha = FechaFormateador.obtenerFechaActual();
    }

    private void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    private void setRechazado(boolean rechazado) {
        this.rechazado = rechazado;
    }
}