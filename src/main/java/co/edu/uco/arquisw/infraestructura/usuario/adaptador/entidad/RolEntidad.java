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
@Table(name = "rol")
public class RolEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "rol_code_seq")
    @SequenceGenerator(name = "rol_code_seq", sequenceName = "rol_code_seq", allocationSize = 1)
    private Long id;
    private String nombre;
    private boolean leer;
    private boolean escribir;
    private boolean actualizar;
    private boolean eliminar;
}