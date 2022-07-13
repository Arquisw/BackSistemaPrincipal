package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.SeleccionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeleccionDAO extends JpaRepository<SeleccionEntidad, Long>
{
}