package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ejecucion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EjecucionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="ejecucion_code_seq")
    @SequenceGenerator(name="ejecucion_code_seq", sequenceName="ejecucion_code_seq", allocationSize=1)
    private int codigo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    @ManyToOne
    @JoinColumn(name = "proyecto")
    private ProyectoEntidad proyecto;
    @OneToOne
    @JoinColumn(name = "postulacion")
    private PostulacionEntidad postulacion;
}