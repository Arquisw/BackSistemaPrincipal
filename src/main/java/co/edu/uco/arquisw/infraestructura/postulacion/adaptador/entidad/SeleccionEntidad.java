package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad;

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
@Table(name = "seleccion")
public class SeleccionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seleccion_code_seq")
    @SequenceGenerator(name="seleccion_code_seq", sequenceName="seleccion_code_seq", allocationSize=1)
    private Long id;
    private String fecha;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "seleccion")
    private List<RolProyectoSeleccionEntidad> roles;
    private Long proyecto;
    private Long usuario;
}