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
@Table(name = "rol_usuario")
public class RolUsuarioEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "rol_usuario_code_seq")
    @SequenceGenerator(name = "rol_usuario_code_seq", sequenceName = "rol_usuario_code_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rol")
    private RolEntidad rol;
}