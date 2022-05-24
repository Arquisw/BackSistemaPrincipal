package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarioasociacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAsociacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="usuarioasociacion_code_seq")
    @SequenceGenerator(name="usuarioasociacion_code_seq", sequenceName="usuarioasociacion_code_seq", allocationSize=1)
    private int codigo;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private UsuarioEntidad usuario;
    @ManyToOne
    @JoinColumn(name = "asociacion")
    private AsociacionEntidad asociacion;
}