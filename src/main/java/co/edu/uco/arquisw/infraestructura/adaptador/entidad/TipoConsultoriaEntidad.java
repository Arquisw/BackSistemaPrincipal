package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tipoconsultoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoConsultoriaEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tipoconsultoria_code_seq")
    @SequenceGenerator(name="tipoconsultoria_code_seq", sequenceName="tipoconsultoria_code_seq", allocationSize=1)
    private int codigo;
    private String nombre;
}
