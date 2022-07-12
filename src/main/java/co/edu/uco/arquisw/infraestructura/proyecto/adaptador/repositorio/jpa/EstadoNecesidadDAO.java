package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.EstadoNecesidadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoNecesidadDAO extends JpaRepository<EstadoNecesidadEntidad, Long>
{
}
