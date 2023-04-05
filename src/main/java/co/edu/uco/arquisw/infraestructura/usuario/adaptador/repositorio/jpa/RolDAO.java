package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDAO extends JpaRepository<RolEntidad, Long> { }