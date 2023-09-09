package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.MotivoRechazoNecesidadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivoRechazoNecesidadDAO extends JpaRepository<MotivoRechazoNecesidadEntidad, Long> {
    MotivoRechazoNecesidadEntidad findByNecesidad(Long necesidad);
}