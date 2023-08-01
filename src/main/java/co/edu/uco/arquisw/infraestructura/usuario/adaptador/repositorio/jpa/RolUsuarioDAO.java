package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolUsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUsuarioDAO extends JpaRepository<RolUsuarioEntidad, Long> { }