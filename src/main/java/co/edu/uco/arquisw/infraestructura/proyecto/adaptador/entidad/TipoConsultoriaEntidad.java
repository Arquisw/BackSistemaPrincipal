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
@Table(name = "tipoconsultoria")
public class TipoConsultoriaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tipoconsultoria_code_seq")
    @SequenceGenerator(name="tipoconsultoria_code_seq", sequenceName="tipoconsultoria_code_seq", allocationSize=1)
    private Long id;
    @Column(length = 24)
    private String nombre;
}