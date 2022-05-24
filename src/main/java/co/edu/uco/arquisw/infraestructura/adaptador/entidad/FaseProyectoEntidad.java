package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "faseproyecto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaseProyectoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="faseproyecto_code_seq")
    @SequenceGenerator(name="faseproyecto_code_seq", sequenceName="faseproyecto_code_seq", allocationSize=1)
    private int codigo;
    @OneToOne
    @JoinColumn(name = "fasedetallada")
    private FaseDetalladaEntidad faseDetallada;
    @OneToOne
    @JoinColumn(name = "faseejecucion")
    private FaseEjecucionEntidad faseEjecucion;
}
