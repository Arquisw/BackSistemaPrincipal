package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.PeticionEliminacionNecesidadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeticionEliminacionNecesidadDAO extends JpaRepository<PeticionEliminacionNecesidadEntidad, Long>
{
    PeticionEliminacionNecesidadEntidad findByNecesidad(Long necesidad);
}
