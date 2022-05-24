package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "estadoentidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoAsociacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="estadoentidad_code_seq")
    @SequenceGenerator(name="estadoentidad_code_seq", sequenceName="estadoentidad_code_seq", allocationSize=1)
    private int codigo;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoEntidad estado;
}