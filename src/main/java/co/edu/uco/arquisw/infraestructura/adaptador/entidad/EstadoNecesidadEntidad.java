package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "estadonecesidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoNecesidadEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="estadonecesidad_code_seq")
    @SequenceGenerator(name="estadonecesidad_code_seq", sequenceName="estadonecesidad_code_seq", allocationSize=1)
    private int codigo;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoEntidad estado;
}
