package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "peticioneliminacionnecesidad")
public class PeticionEliminacionNecesidadEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="peticioneliminacionnecesidad_code_seq")
    @SequenceGenerator(name="peticioneliminacionnecesidad_code_seq", sequenceName="peticioneliminacionnecesidad_code_seq", allocationSize=1)
    private Long id;
    private Long necesidad;
}