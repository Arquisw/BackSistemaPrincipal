package co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<UsuarioEntidad, Integer>
{
    UsuarioEntidad findByCorreo(String correo);
    UsuarioEntidad findByNumeroIdentificacion(String numeroIdentificacion);
}