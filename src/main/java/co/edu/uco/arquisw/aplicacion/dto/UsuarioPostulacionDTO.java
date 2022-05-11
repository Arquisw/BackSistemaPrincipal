package co.edu.uco.arquisw.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPostulacionDTO
{
    private int codigo;
    private boolean estaSeleccionado;
    private UsuarioDTO usuario;
    private PostulacionDTO postulacion;
    private RolDTO rol;
}
