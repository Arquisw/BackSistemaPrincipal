package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="perfil_code_seq")
    @SequenceGenerator(name="perfil_code_seq", sequenceName="perfil_code_seq", allocationSize=1)
    private int codigo;
    private String nombre;
}