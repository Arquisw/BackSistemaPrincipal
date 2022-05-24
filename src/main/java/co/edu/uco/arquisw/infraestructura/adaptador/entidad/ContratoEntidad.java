package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contrato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="contrato_code_seq")
    @SequenceGenerator(name="contrato_code_seq", sequenceName="contrato_code_seq", allocationSize=1)
    private int codigo;
    private String urlArchivo;
}