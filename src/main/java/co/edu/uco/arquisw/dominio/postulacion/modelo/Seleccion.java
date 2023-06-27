package co.edu.uco.arquisw.dominio.postulacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

@Getter
public class Seleccion {
    private LocalDate fecha;
    private List<String> roles;

    private Seleccion(List<String> roles) {
        setFecha();
        setRoles(roles);
    }

    public static Seleccion crear(List<String> roles) {
        return new Seleccion(roles);
    }

    private void setRoles(List<String> roles) {
        roles.forEach(rol -> {
            ValidarTexto.validarObligatorio(rol, Mensajes.NOMBRE_ROL_VACIO);
            ValidarTexto.validarPatronAlfanumericoEsValido(rol, Mensajes.PATRON_NOMBRE_ROL_INVALIDO);
        });

        this.roles = roles;
    }

    public void setFecha() {
        this.fecha = FechaFormateador.obtenerFechaActual();
    }
}