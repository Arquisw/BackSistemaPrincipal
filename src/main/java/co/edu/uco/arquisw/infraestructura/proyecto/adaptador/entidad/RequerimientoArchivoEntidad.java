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
@Table(name = "requerimiento_archivo")
public class RequerimientoArchivoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "requerimiento_archivo_code_seq")
    @SequenceGenerator(name = "requerimiento_archivo_code_seq", sequenceName = "requerimiento_archivo_code_seq", allocationSize = 1)
    private Long id;
    @Column(length = 3000)
    private String ruta;
    private Long necesidad;
}