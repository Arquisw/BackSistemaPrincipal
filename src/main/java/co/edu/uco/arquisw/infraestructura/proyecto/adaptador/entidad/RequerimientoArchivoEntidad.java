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
@Table(name = "requerimientoarchivo")
public class RequerimientoArchivoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="requerimientoarchivo_code_seq")
    @SequenceGenerator(name="requerimientoarchivo_code_seq", sequenceName="requerimientoarchivo_code_seq", allocationSize=1)
    private Long id;
    @Column(length = 3000)
    private String ruta;
    private Long necesidad;
}