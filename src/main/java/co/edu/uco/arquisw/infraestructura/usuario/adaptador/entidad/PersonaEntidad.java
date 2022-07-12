package co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
public class PersonaEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="persona_code_seq")
    @SequenceGenerator(name="persona_code_seq", sequenceName="persona_code_seq", allocationSize=1)
    private Long id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String apellidos;
    @Column(length = 100)
    private String correo;
    @OneToMany
    @JoinColumn(name = "persona")
    private List<RolPersonaEntidad> roles;
}