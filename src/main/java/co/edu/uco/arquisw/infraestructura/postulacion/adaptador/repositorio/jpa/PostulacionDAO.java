package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.PostulacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulacionDAO extends JpaRepository<PostulacionEntidad, Long> {
    List<PostulacionEntidad> findByUsuario(Long usuario);
}