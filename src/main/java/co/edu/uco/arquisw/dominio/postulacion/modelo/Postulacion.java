package co.edu.uco.arquisw.dominio.postulacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Postulacion {
    private LocalDate fecha;
    private String rol;
    private boolean seleccionado;

    private Postulacion(String rol, boolean seleccionado) {
        setFecha();
        setRol(rol);
        setSeleccionado(seleccionado);
    }

    public static Postulacion crear(String rol, boolean seleccionado) {
        return new Postulacion(rol, seleccionado);
    }

    private void setRol(String rol) {
        ValidarTexto.validarObligatorio(rol, Mensajes.NOMBRE_ROL_VACIO);
        ValidarTexto.validarPatronAlfanumericoEsValido(rol, Mensajes.PATRON_NOMBRE_ROL_INVALIDO);

        this.rol = rol;
    }

    private void setFecha() {
        this.fecha = FechaFormateador.obtenerFechaActual();
    }

    private void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void seleccionarPostulante() {
        this.seleccionado = true;
    }
}