package co.edu.uco.arquisw.dominio.ensamblador;

import co.edu.uco.arquisw.aplicacion.dto.ComentarioDTO;
import co.edu.uco.arquisw.dominio.modelo.Comentario;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.ComentarioEntidad;

public interface ComentarioEnsamblador extends Ensamblador<Comentario, ComentarioEntidad, ComentarioDTO>
{

}