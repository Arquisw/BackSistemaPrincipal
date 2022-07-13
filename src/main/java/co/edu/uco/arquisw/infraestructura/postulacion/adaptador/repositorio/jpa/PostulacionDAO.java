package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.PostulacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionDAO extends JpaRepository<PostulacionEntidad, Long>
{
}