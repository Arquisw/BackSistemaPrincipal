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
@Table(name = "estadonecesidad")
public class EstadoNecesidadEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="estadonecesidad_code_seq")
    @SequenceGenerator(name="estadonecesidad_code_seq", sequenceName="estadonecesidad_code_seq", allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoEntidad estado;
}
