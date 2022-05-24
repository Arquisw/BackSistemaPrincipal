package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "asociacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsociacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="asociacion_code_seq")
    @SequenceGenerator(name="asociacion_code_seq", sequenceName="asociacion_code_seq", allocationSize=1)
    private int codigo;
    private String nit;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoAsociacionEntidad estado;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "necesidad")
    private NecesidadEntidad necesidad;
}