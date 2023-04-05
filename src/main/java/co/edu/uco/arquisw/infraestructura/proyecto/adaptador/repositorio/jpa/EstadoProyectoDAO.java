package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.EstadoProyectoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoProyectoDAO extends JpaRepository<EstadoProyectoEntidad, Long> { }