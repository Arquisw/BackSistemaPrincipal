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
@Table(name = "tipo_consultoria_proyecto")
public class TipoConsultoriaProyectoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tipo_consultoria_proyecto_code_seq")
    @SequenceGenerator(name = "tipo_consultoria_proyecto_code_seq", sequenceName = "tipo_consultoria_proyecto_code_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tipo_consultoria")
    private TipoConsultoriaEntidad tipoConsultoria;
}