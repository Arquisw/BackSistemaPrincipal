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
@Table(name = "necesidad")
public class NecesidadEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "necesidad_code_seq")
    @SequenceGenerator(name = "necesidad_code_seq", sequenceName = "necesidad_code_seq", allocationSize = 1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "estado")
    private EstadoNecesidadEntidad estado;
    @OneToOne
    @JoinColumn(name = "proyecto")
    private ProyectoEntidad proyecto;
    private Long asociacion;
}