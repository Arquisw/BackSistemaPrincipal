package co.edu.uco.arquisw.dominio.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO
{
    private Long id;
    private String nombre;
    private String apellidos;
    private String correo;
    private List<RolDTO> roles;
}