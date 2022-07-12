package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.TipoConsultoriaProyectoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoConsultoriaProyectoDAO extends JpaRepository<TipoConsultoriaProyectoEntidad, Long>
{

}