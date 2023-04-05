package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.EstadoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoDAO extends JpaRepository<EstadoEntidad, Long> { }