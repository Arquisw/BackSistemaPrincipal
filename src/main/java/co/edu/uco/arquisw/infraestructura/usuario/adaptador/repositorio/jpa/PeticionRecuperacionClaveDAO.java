package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionRecuperacionClaveEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeticionRecuperacionClaveDAO extends JpaRepository<PeticionRecuperacionClaveEntidad, Long> {
    PeticionRecuperacionClaveEntidad findByCorreo(String correo);
}