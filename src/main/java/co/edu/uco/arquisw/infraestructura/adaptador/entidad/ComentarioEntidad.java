package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comentario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="comentario_code_seq")
    @SequenceGenerator(name="comentario_code_seq", sequenceName="comentario_code_seq", allocationSize=1)
    private int codigo;
    private String descripcion;
}