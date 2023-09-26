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
@Table(name = "peticion_activacion_cuenta")
public class PeticionActivacionCuentaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "peticion_activacion_cuenta_code_seq")
    @SequenceGenerator(name = "peticion_activacion_cuenta_code_seq", sequenceName = "peticion_activacion_cuenta_code_seq", allocationSize = 1)
    private Long id;
    private String codigo;
    private String correo;
    private String fecha;
}