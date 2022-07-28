package co.edu.uco.arquisw.infraestructura.postulacion.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;

public class PostulacionDtoTestDataBuilder {
    private Long proyectoID;
    private Long usuarioID;
    private String rol;

    public PostulacionDtoTestDataBuilder()
    {
        this.proyectoID = 2L;
        this.usuarioID = 8L;
        this.rol="Interezado";
    }
    public PostulacionComando build()
    {
        return new PostulacionComando(rol,proyectoID,usuarioID);
    }

    public PostulacionComando buildFallida()
    {
        return new PostulacionComando(rol,proyectoID,usuarioID);
    }
}
