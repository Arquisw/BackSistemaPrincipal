package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.entidad;

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
@Table(name = "peticioneliminacionasociacion")
public class PeticionEliminacionAsociacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="peticioneliminacionasociacion_code_seq")
    @SequenceGenerator(name="peticioneliminacionasociacion_code_seq", sequenceName="peticioneliminacionasociacion_code_seq", allocationSize=1)
    private Long id;
    private Long asociacion;
}