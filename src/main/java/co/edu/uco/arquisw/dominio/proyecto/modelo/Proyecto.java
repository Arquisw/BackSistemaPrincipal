package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;
import java.util.List;

@Getter
public class Proyecto {
    private String nombre;
    private String descripcion;
    private final EstadoProyecto estado;
    private final AprobacionProyecto aprobacionProyecto;
    private final List<TipoConsultoria> tiposConsultoria;

    private Proyecto(String nombre, String descripcion, EstadoProyecto estado, AprobacionProyecto aprobacionProyecto, List<TipoConsultoria> tiposConsultoria) {
        setNombre(nombre);
        setDescripcion(descripcion);
        this.estado = estado;
        this.aprobacionProyecto = aprobacionProyecto;
        this.tiposConsultoria = tiposConsultoria;
    }

    public static Proyecto crear(String nombre, String descripcion, EstadoProyecto estado, List<TipoConsultoria> tiposConsultoria) {
        return new Proyecto(nombre, descripcion, estado, AprobacionProyecto.crear(), tiposConsultoria);
    }

    public void setNombre(String nombre) {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NOMBRE_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronAlfanumericoEsValido(nombre, Mensajes.PATRON_NOMBRE_PROYECTO_NO_ES_VALIDO);

        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        ValidarTexto.validarObligatorio(descripcion, Mensajes.DESCRIPCION_ESTADO_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronAlfanumericoEsValido(descripcion, Mensajes.PATRON_DESCRIPCION_PROYECTO_NO_ES_VALIDO);

        this.descripcion = descripcion;
    }
}