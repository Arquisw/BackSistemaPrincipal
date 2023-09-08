package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.SeleccionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeleccionDAO extends JpaRepository<SeleccionEntidad, Long> {
    List<SeleccionEntidad> findByUsuario(Long usuario);
}