package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="estado_code_seq")
    @SequenceGenerator(name="estado_code_seq", sequenceName="estado_code_seq", allocationSize=1)
    private int codigo;
    private String nombre;
}