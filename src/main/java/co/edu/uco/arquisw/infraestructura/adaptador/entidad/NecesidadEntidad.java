package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "necesidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NecesidadEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="necesidad_code_seq")
    @SequenceGenerator(name="necesidad_code_seq", sequenceName="necesidad_code_seq", allocationSize=1)
    private int codigo;
    private int tiempo;
    private String rutaArchivo;
    @ManyToOne
    @JoinColumn(name = "proyecto")
    private ProyectoEntidad proyecto;
    @ManyToOne
    @JoinColumn(name = "estadonecesidad")
    private EstadoNecesidadEntidad estado;
}