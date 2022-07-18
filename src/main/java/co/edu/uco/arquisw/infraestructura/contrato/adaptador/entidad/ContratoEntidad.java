package co.edu.uco.arquisw.infraestructura.contrato.adaptador.entidad;

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
@Table(name = "contrato")
public class ContratoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="contrato_code_seq")
    @SequenceGenerator(name="contrato_code_seq", sequenceName="contrato_code_seq", allocationSize=1)
    private Long id;
    @Column(length = 3000)
    private String ruta;
    private Long asociacion;
}