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
@Table(name = "seleccion")
public class SeleccionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seleccion_code_seq")
    @SequenceGenerator(name="seleccion_code_seq", sequenceName="seleccion_code_seq", allocationSize=1)
    private Long id;
    private String fecha;
    private Long proyectoID;
    private Long usuarioID;
}