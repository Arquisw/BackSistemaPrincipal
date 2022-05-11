package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPostulacionEntidad
{
    private int codigo;
    private boolean estaSeleccionado;
    private UsuarioEntidad usuario;
    private PostulacionEntidad postulacion;
    private RolEntidad rol;
}
