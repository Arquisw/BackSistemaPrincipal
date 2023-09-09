package co.edu.uco.arquisw.infraestructura.postulacion.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;

import java.util.List;

public class PostulacionDtoTestDataBuilder {
    private Long proyectoID;
    private Long usuarioID;
    private String rol;

    public PostulacionDtoTestDataBuilder() {
        this.proyectoID = 2L;
        this.usuarioID = 8L;
        this.rol = "Interezado";
    }

    public PostulacionComando build() {
        return new PostulacionComando(List.of(rol), proyectoID, usuarioID);
    }

    public PostulacionComando buildFallida() {
        return new PostulacionComando(List.of(rol), proyectoID, usuarioID);
    }
}