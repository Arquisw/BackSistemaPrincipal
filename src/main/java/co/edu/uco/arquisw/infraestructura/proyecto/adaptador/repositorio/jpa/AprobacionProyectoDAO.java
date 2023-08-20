package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.AprobacionProyectoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AprobacionProyectoDAO extends JpaRepository<AprobacionProyectoEntidad, Long> {

}