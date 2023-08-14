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
@Table(name = "motivo_rechazo_postulacion")
public class MotivoRechazoPostulacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="motivo_rechazo_postulacion_code_seq")
    @SequenceGenerator(name="motivo_rechazo_postulacion_code_seq", sequenceName="motivo_rechazo_postulacion_code_seq", allocationSize=1)
    private Long id;
    private String motivo;
    private Long postulacion;
}