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
@Table(name = "peticion_recuperacion_clave")
public class PeticionRecuperacionClaveEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="peticion_recuperacion_clave_code_seq")
    @SequenceGenerator(name="peticion_recuperacion_clave_code_seq", sequenceName="peticion_recuperacion_clave_code_seq", allocationSize=1)
    private Long id;
    private String codigo;
    private String correo;
    private String fecha;
}
