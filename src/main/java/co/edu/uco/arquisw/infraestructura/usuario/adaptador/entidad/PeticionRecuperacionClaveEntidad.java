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
@Table(name = "peticionrecuperacionclave")
public class PeticionRecuperacionClaveEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="peticionrecuperacionclave_code_seq")
    @SequenceGenerator(name="peticionrecuperacionclave_code_seq", sequenceName="peticionrecuperacionclave_code_seq", allocationSize=1)
    private Long id;
    private String codigo;
    private String correo;
    private String fecha;
}
