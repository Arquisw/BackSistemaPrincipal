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
@Table(name = "usuario")
public class UsuarioEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="usuario_code_seq")
    @SequenceGenerator(name="usuario_code_seq", sequenceName="usuario_code_seq", allocationSize=1)
    private Long id;
    @Column(length = 100)
    private String correo;
    private String clave;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private List<RolUsuarioEntidad> roles;
}