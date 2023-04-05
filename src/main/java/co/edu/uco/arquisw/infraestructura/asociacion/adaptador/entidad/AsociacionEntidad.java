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
@Table(name = "asociacion")
public class AsociacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="asociacion_code_seq")
    @SequenceGenerator(name="asociacion_code_seq", sequenceName="asociacion_code_seq", allocationSize=1)
    private Long id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 11)
    private String nit;
    @Column(length = 15)
    private String numeroContacto;
    private Long usuario;
}