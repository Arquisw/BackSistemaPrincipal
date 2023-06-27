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
@Table(name = "rolseleccion")
public class RolProyectoSeleccionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="rolseleccion_code_seq")
    @SequenceGenerator(name="rolseleccion_code_seq", sequenceName="rolseleccion_code_seq", allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rolproyecto")
    private RolProyectoEntidad rol;
}
