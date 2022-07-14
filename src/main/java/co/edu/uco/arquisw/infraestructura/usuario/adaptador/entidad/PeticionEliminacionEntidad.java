package co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad;

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
@Table(name = "peticioneliminacion")
public class PeticionEliminacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="peticioneliminacion_code_seq")
    @SequenceGenerator(name="peticioneliminacion_code_seq", sequenceName="peticioneliminacion_code_seq", allocationSize=1)
    private Long id;
    private Long usuario;
}