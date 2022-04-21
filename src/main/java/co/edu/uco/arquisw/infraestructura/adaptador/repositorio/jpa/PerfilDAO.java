package co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PerfilEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilDAO extends JpaRepository<PerfilEntidad, Integer>
{

}
