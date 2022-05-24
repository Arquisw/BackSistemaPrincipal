package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.ComentarioDTO;
import co.edu.uco.arquisw.dominio.ensamblador.ComentarioEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Comentario;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.ComentarioEntidad;

public class ComentarioEnsambladorImplementacion implements ComentarioEnsamblador
{
    private static final ComentarioEnsamblador INSTANCE = new ComentarioEnsambladorImplementacion();

    private ComentarioEnsambladorImplementacion()
    {

    }

    public static ComentarioEnsamblador obtenerComentarioEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Comentario ensamblarDominioDesdeEntidad(ComentarioEntidad entidad)
    {
        return null;
    }

    @Override
    public ComentarioEntidad ensamblarEntidadDesdeDominio(Comentario dominio)
    {
        return null;
    }

    @Override
    public Comentario ensamblarDominioDesdeDTO(ComentarioDTO dto)
    {
        return null;
    }

    @Override
    public ComentarioDTO ensamblarDTODesdeDominio(Comentario dominio)
    {
        return null;
    }
}