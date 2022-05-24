package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "requerimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequerimientoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="requerimiento_code_seq")
    @SequenceGenerator(name="requerimiento_code_seq", sequenceName="requerimiento_code_seq", allocationSize=1)
    private int codigo;
    @ManyToOne
    @JoinColumn(name = "necesidad")
    private NecesidadEntidad necesidad;
    @OneToOne
    @JoinColumn(name = "contrato")
    private ContratoEntidad contrato;
}