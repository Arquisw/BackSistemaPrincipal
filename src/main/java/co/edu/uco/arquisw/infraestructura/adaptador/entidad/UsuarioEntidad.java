package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="usuario_code_seq")
    @SequenceGenerator(name="usuario_code_seq", sequenceName="usuario_code_seq", allocationSize=1)
    private int codigo;
    private String nombre;
    private String apellidos;
    private String numeroIdentificacion;
    private String correo;
    private String clave;
    private String institucion;
    @OneToMany
    @JoinColumn(name = "usuario")
    private List<PerfilUsuarioEntidad> perfiles;
}