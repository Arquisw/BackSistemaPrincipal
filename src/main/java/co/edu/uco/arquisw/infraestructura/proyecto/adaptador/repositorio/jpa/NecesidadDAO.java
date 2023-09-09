package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.NecesidadEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.ProyectoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NecesidadDAO extends JpaRepository<NecesidadEntidad, Long> {
    NecesidadEntidad findByAsociacion(Long asociacion);

    NecesidadEntidad findByProyecto(ProyectoEntidad proyecto);
}