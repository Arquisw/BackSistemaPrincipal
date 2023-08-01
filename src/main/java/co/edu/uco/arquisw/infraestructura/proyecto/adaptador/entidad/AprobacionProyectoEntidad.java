package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad;

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
@Table(name = "aprobacion_proyecto")
public class AprobacionProyectoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="aprobacion_proyecto_code_seq")
    @SequenceGenerator(name="aprobacion_proyecto_code_seq", sequenceName="aprobacion_proyecto_code_seq", allocationSize=1)
    private Long id;
    private boolean ingenieria;
    private boolean liderDeEquipo;
    private boolean directorDeProyecto;
}
