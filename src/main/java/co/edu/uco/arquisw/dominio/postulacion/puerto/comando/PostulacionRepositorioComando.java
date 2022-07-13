package co.edu.uco.arquisw.dominio.postulacion.puerto.comando;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;

public interface PostulacionRepositorioComando
{
    Long guardar(Postulacion postulacion, Long proyectoID, Long usuarioID);
    Long Actualizar(Postulacion postulacion, Long id);
}