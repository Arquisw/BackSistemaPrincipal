package co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoDAO extends JpaRepository<EstadoEntidad, Integer>
{

}