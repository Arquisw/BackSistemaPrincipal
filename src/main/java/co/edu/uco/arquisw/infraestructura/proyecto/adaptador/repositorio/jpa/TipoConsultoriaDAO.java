package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.TipoConsultoriaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoConsultoriaDAO extends JpaRepository<TipoConsultoriaEntidad, Long> {
}