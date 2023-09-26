package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionActivacionCuentaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeticionActivacionCuentaDAO extends JpaRepository<PeticionActivacionCuentaEntidad, Long> {
    PeticionActivacionCuentaEntidad findByCorreo(String correo);
}