package co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad;

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
@Table(name = "peticioneliminacionpersona")
public class PeticionEliminacionPersonaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="peticioneliminacionpersona_code_seq")
    @SequenceGenerator(name="peticioneliminacionpersona_code_seq", sequenceName="peticioneliminacionpersona_code_seq", allocationSize=1)
    private Long id;
    private Long usuario;
}