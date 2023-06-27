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
@Table(name = "rolpostulacion")
public class RolProyectoPostulacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="rolpostulacion_code_seq")
    @SequenceGenerator(name="rolpostulacion_code_seq", sequenceName="rolpostulacion_code_seq", allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rolproyecto")
    private RolProyectoEntidad rol;
}
