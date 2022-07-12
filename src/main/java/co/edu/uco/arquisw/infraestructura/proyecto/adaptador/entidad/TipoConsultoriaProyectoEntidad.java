package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad;

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
@Table(name = "tipoconsultoriaproyecto")
public class TipoConsultoriaProyectoEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tipoconsultoriaproyecto_code_seq")
    @SequenceGenerator(name="tipoconsultoriaproyecto_code_seq", sequenceName="tipoconsultoriaproyecto_code_seq", allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tipoconsultoria")
    private TipoConsultoriaEntidad tipoConsultoria;
}