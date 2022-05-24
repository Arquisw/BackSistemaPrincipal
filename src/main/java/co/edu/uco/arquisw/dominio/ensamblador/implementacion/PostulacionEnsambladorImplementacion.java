package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.ensamblador.PostulacionEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Postulacion;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PostulacionEntidad;

public class PostulacionEnsambladorImplementacion implements PostulacionEnsamblador
{
    private static final PostulacionEnsamblador INSTANCE = new PostulacionEnsambladorImplementacion();

    private PostulacionEnsambladorImplementacion()
    {

    }

    public static PostulacionEnsamblador obtenerPostulacionEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Postulacion ensamblarDominioDesdeEntidad(PostulacionEntidad entidad)
    {
        return null;
    }

    @Override
    public PostulacionEntidad ensamblarEntidadDesdeDominio(Postulacion dominio)
    {
        return null;
    }

    @Override
    public Postulacion ensamblarDominioDesdeDTO(PostulacionDTO dto)
    {
        return null;
    }

    @Override
    public PostulacionDTO ensamblarDTODesdeDominio(Postulacion dominio)
    {
        return null;
    }
}