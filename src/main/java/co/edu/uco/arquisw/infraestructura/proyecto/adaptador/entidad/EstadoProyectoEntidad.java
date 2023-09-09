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
@Table(name = "estado_proyecto")
public class EstadoProyectoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "estado_proyecto_code_seq")
    @SequenceGenerator(name = "estado_proyecto_code_seq", sequenceName = "estado_proyecto_code_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoEntidad estado;
}