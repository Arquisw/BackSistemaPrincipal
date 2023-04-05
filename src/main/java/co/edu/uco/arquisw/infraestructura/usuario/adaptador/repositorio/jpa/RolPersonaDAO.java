package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolPersonaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolPersonaDAO extends JpaRepository<RolPersonaEntidad, Long> { }