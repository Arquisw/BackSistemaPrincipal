package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarioadministrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAdministradorEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="usuarioadministrador_code_seq")
    @SequenceGenerator(name="usuarioadministrador_code_seq", sequenceName="usuarioadministrador_code_seq", allocationSize=1)
    private int codigo;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private UsuarioEntidad usuario;
    @OneToMany
    @JoinColumn(name = "usuarioadministrador")
    private List<RequerimientoEntidad> requerimientos;
    @OneToMany
    @JoinColumn(name = "usuarioadministrador")
    private List<UsuarioPostulacionEntidad> usuariosPostulados;
}