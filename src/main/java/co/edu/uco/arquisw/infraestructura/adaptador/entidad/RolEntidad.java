package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="rol_code_seq")
    @SequenceGenerator(name="rol_code_seq", sequenceName="rol_code_seq", allocationSize=1)
    private int codigo;
    private String nombre;
}