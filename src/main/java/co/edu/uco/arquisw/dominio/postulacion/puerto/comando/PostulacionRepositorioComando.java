package co.edu.uco.arquisw.dominio.postulacion.puerto.comando;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;

public interface PostulacionRepositorioComando
{
    Long guardar(Postulacion postulacion, Long proyectoID, Long usuarioID);
    Long actualizar(Postulacion postulacion, Seleccion seleccion, Long id);
}