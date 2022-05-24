package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuariopostulacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPostulacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="usuariopostulacion_code_seq")
    @SequenceGenerator(name="usuariopostulacion_code_seq", sequenceName="usuariopostulacion_code_seq", allocationSize=1)
    private int codigo;
    private boolean estaSeleccionado;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private UsuarioEntidad usuario;
    @ManyToOne
    @JoinColumn(name = "postulacion")
    private PostulacionEntidad postulacion;
    @ManyToOne
    @JoinColumn(name = "rol")
    private RolEntidad rol;
}
