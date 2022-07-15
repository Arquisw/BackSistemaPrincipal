package co.edu.uco.arquisw.infraestructura.postulacion.testdatabuilder;

import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;

public class PostulacionDtoTestDataBuilder {
    private Long proyectoID;
    private Long usuarioID;

    public PostulacionDtoTestDataBuilder()
    {
        this.proyectoID = 1L;
        this.usuarioID = 1L;
    }
    public PostulacionComando build()
    {
        return new PostulacionComando(proyectoID,usuarioID);
    }
}
