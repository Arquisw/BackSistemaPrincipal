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
@Table(name = "peticion_eliminacion_asociacion")
public class PeticionEliminacionAsociacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="peticion_eliminacion_asociacion_code_seq")
    @SequenceGenerator(name="peticion_eliminacion_asociacion_code_seq", sequenceName="peticion_eliminacion_asociacion_code_seq", allocationSize=1)
    private Long id;
    private Long asociacion;
}