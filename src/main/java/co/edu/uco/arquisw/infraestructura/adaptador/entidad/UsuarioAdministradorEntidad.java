package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAdministradorEntidad
{
    private int codigo;
    private UsuarioEntidad usuario;
    private List<RequerimientoEntidad> requerimientos;
    private List<UsuarioPostulacionEntidad> usuariosPostulados;
}