package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.ProyectoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoDAO extends JpaRepository<ProyectoEntidad, Long>
{

}