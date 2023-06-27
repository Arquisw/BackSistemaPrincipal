package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.RolPersonaEntidad;
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
@Table(name = "postulacion")
public class PostulacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="postulacion_code_seq")
    @SequenceGenerator(name="postulacion_code_seq", sequenceName="postulacion_code_seq", allocationSize=1)
    private Long id;
    private boolean seleccionado;
    private String fecha;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postulacion")
    private List<RolProyectoPostulacionEntidad> roles;
    private Long proyecto;
    private Long usuario;
}