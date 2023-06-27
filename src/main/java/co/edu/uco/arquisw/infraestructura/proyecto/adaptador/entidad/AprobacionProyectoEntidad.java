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
@Table(name = "aprobacionproyecto")
public class AprobacionProyectoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="aprobacionproyecto_code_seq")
    @SequenceGenerator(name="aprobacionproyecto_code_seq", sequenceName="aprobacionproyecto_code_seq", allocationSize=1)
    private Long id;
    private boolean ingenieria;
    private boolean liderDeEquipo;
    private boolean directorDeProyecto;
}
