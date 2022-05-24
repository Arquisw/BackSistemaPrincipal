package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "faseejecucion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaseEjecucionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="faseejecucion_code_seq")
    @SequenceGenerator(name="faseejecucion_code_seq", sequenceName="faseejecucion_code_seq", allocationSize=1)
    private int codigo;
    private boolean estado;
    private String urlDocumentacion;
    @OneToMany
    @JoinColumn(name = "faseejecucion")
    private List<ComentarioEntidad> comentarios;
}