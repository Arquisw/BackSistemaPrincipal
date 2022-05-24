package co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.adaptador.entidad.EstadoAsociacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoAsociacionDAO extends JpaRepository<EstadoAsociacionEntidad, Integer>
{

}