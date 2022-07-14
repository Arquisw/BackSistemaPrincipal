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
@Table(name = "hojadevida")
public class HojaDeVidaPersonaEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="hojadevida_code_seq")
    @SequenceGenerator(name="hojadevida_code_seq", sequenceName="hojadevida_code_seq", allocationSize=1)
    private Long id;
    private String ruta;
    private Long usuario;
}
