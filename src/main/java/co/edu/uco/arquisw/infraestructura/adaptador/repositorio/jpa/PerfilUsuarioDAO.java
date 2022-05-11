package co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PerfilUsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilUsuarioDAO extends JpaRepository<PerfilUsuarioEntidad, Integer>
{

}