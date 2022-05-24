package co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioAsociacionEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioAsociacionDAO extends JpaRepository<UsuarioAsociacionEntidad, Integer>
{

}