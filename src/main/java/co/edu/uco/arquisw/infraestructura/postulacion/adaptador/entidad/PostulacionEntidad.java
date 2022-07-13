package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad;

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
@Table(name = "postulacion")
public class PostulacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="postulacion_code_seq")
    @SequenceGenerator(name="postulacion_code_seq", sequenceName="postulacion_code_seq", allocationSize=1)
    private Long id;
    private boolean seleccionado;
    private String fecha;
    private Long proyectoID;
    private Long usuarioID;
}