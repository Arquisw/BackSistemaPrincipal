package co.edu.uco.arquisw.infraestructura.postulacion.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;

import java.util.List;

public class PostulacionDtoTestDataBuilder {
    private Long proyectoID;
    private Long usuarioID;
    private String rol;

    public PostulacionDtoTestDataBuilder() {
        this.proyectoID = NumeroConstante.DOS;
        this.usuarioID = NumeroConstante.OCHO;
        this.rol = "Interesado";
    }

    public PostulacionComando build() {
        return new PostulacionComando(List.of(rol), proyectoID, usuarioID);
    }

    public PostulacionComando buildFallida() {
        return new PostulacionComando(List.of(rol), proyectoID, usuarioID);
    }
}