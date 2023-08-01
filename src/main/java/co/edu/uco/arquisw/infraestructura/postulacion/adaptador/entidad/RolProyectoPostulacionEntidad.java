package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad;

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
@Table(name = "rol_postulacion")
public class RolProyectoPostulacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="rol_postulacion_code_seq")
    @SequenceGenerator(name="rol_postulacion_code_seq", sequenceName="rol_postulacion_code_seq", allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rol_proyecto")
    private RolProyectoEntidad rol;
}
