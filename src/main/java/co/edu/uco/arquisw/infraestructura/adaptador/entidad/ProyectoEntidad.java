package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "proyecto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="proyecto_code_seq")
    @SequenceGenerator(name="proyecto_code_seq", sequenceName="proyecto_code_seq", allocationSize=1)
    private int codigo;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoProyectoEntidad estado;
    @OneToOne
    @JoinColumn(name = "fase")
    private FaseProyectoEntidad fase;
    @ManyToOne
    @JoinColumn(name = "tipoconsultoria")
    private TipoConsultoriaEntidad tipoConsultoria;
}