package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "estadoproyecto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoProyectoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="estadoproyecto_code_seq")
    @SequenceGenerator(name="estadoproyecto_code_seq", sequenceName="estadoproyecto_code_seq", allocationSize=1)
    private int codigo;
    private String nombre;
}