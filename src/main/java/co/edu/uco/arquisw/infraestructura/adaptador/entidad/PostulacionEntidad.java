package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "postulacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostulacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="postulacion_code_seq")
    @SequenceGenerator(name="postulacion_code_seq", sequenceName="postulacion_code_seq", allocationSize=1)
    private int codigo;
    private LocalDate fechaPostulacion;
}
