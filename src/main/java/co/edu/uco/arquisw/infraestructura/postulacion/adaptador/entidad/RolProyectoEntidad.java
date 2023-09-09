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
@Table(name = "rol_proyecto")
public class RolProyectoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "rol_proyecto_code_seq")
    @SequenceGenerator(name = "rol_proyecto_code_seq", sequenceName = "rol_proyecto_code_seq", allocationSize = 1)
    private Long id;
    private String nombre;
}