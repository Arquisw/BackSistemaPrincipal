package co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad;

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
@Table(name = "hoja_de_vida")
public class HojaDeVidaPersonaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="hoja_de_vida_code_seq")
    @SequenceGenerator(name="hoja_de_vida_code_seq", sequenceName="hoja_de_vida_code_seq", allocationSize=1)
    private Long id;
    @Column(length = 3000)
    private String ruta;
    private Long usuario;
}